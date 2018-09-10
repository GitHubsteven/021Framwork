package proxytest;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/7
 * @Time: 19:11
 * @Description:
 * @version: 1.0.0
 */
public class AProxyChain {
    private List<AProxy> proxyList;

    public AProxyChain(List<AProxy> proxyList) {
        this.proxyList = proxyList;
    }

    private int index = 0;
    //执行代理链的话，从0开始，获取第一个proxy，执行proxy的代理业务，执行完本次代理业务后，执行当传入的代理链，重新
//    执行doProxyChain
    public Object doProxyChain() {
        Object methodResult;
        //如果代理索引小于代理长度
        if (index < proxyList.size()) {
            AProxy proxy = proxyList.get(index++);
            methodResult = proxy.doProxy(this);
        } else {
            //do nothing
            methodResult = null;
        }
        return methodResult;
    }
}