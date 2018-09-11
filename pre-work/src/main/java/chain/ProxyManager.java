package chain;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.asa.framewrok.proxy.Proxy;
import org.asa.framewrok.proxy.ProxyChain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/7
 * @Time: 19:56
 * @Description:
 * @version: 1.0.0
 */
public class ProxyManager {
    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        //noinspection unchecked
        return (T) Enhancer.create(targetClass, (MethodInterceptor)
                (o, method, objects, methodProxy) -> new ProxyChain(targetClass, o, method, methodProxy, objects, proxyList).doProxyChain());
    }
}