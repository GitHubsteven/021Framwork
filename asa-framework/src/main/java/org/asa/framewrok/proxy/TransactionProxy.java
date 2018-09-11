package org.asa.framewrok.proxy;

import org.asa.framewrok.annotation.Transaction;
import org.asa.framewrok.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/28
 * @Time: 15:02
 * @Description:
 * @version: 1.0.0
 */
public class TransactionProxy implements Proxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);
    private static final ThreadLocal<Boolean> FLAG_HOLDER = ThreadLocal.withInitial(() -> false);


    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;
        Boolean flag = FLAG_HOLDER.get();
        Method method = proxyChain.getTargetMethod();
        //在代理中执行方法代理的时候，判断是否声明了事务，如果声明了并且当前的线程线程池的事务没有被提交
        if (!flag && method.isAnnotationPresent(Transaction.class)) {
            try {
                FLAG_HOLDER.set(true);
                DatabaseHelper.beginTransaction();
                LOGGER.debug("begin transaction!");
                result = proxyChain.doProxyChain();
                DatabaseHelper.commitTransaction();
                LOGGER.debug("commit transaction!");
            } catch (Throwable throwable) {
                DatabaseHelper.rollbackTransaction();
                LOGGER.debug("rollback transaction");
                throw throwable;
            } finally {
                FLAG_HOLDER.remove();
            }
        } else {
            result = proxyChain.doProxyChain();
        }

        return result;
    }
}