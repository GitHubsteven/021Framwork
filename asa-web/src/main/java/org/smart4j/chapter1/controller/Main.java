package org.smart4j.chapter1.controller;


import org.asa.framewrok.proxy.Proxy;
import org.asa.framewrok.proxy.ProxyManager;
import org.smart4j.chapter1.aspect.ControllerAspect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/1
 * @Time: 15:41
 * @Description:
 * @version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Class cls = CustomerController.class;
        List<Proxy> proxies = new ArrayList<>();
        proxies.add(new ControllerAspect());
        Object proxy = ProxyManager.createProxy(cls, proxies);
        System.out.println(proxy.getClass());
    }
}