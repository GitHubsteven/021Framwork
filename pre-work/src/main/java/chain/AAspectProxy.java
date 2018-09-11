package chain;

import org.asa.framewrok.proxy.Proxy;
import org.asa.framewrok.proxy.ProxyChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/10
 * @Time: 15:34
 * @Description: 这里终归只是一个切面的定义而已。
 * @version: 1.0.0
 */
public abstract class AAspectProxy implements Proxy {
    private static Logger logger = LoggerFactory.getLogger(AAspectProxy.class);

    /**
     * 执行链式代理
     *
     * @param proxyChain
     */
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] methodParams = proxyChain.getMethodParams();

        try {
            if (intercept(cls, method, methodParams)) {
                before(cls, method, methodParams);
                result = proxyChain.doProxyChain();
                after(cls, method, methodParams, result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            error(cls,method,methodParams,throwable);
            throw throwable;            //处理了异常为什么还要抛出来呢？因为给业务开发用吗？
        }finally {
            end();
        }
        return result;
    }

    public void begin() {
    }

    ;

    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable {
        return true;
    }

    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
    }

    //传递参数地址进after，意味着可以改变这个值?
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable e) throws Throwable {
    }

    public void end() {
    }
}