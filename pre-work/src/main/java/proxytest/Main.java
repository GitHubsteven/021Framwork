package proxytest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/7
 * @Time: 19:35
 * @Description:
 * @version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        AProxy proxy1 = new AProxy(1);
        AProxy proxy2 = new AProxy(2);
        AProxy proxy3 = new AProxy(3);
        List<AProxy> proxyList = new ArrayList<>();
        proxyList.add(proxy1);
        proxyList.add(proxy2);
        proxyList.add(proxy3);

        AProxyChain proxyChain = new AProxyChain(proxyList);

        proxyChain.doProxyChain();
    }
}