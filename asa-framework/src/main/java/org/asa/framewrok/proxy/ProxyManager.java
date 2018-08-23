package org.asa.framewrok.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/23
 * @Time: 15:05
 * @Description:
 * @version: 1.0.0
 */
public class ProxyManager {
    @SuppressWarnings("unchecked")
    public <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass, (MethodInterceptor) (targetObject, method, objects, methodProxy) ->
                new ProxyChain(targetClass, targetObject, method, methodProxy, objects, proxyList));
    }
}