package org.asa.framewrok.proxy;

/**
 * 代理接口
 *
 * @author huangyong
 * @since 1.0.0
 */
public interface Proxy {

    /**
     * 执行链式代理，你到底执行的是什么呢？
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}