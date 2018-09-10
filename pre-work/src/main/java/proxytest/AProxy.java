package proxytest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/7
 * @Time: 19:10
 * @Description:
 * @version: 1.0.0
 */
public class AProxy {
    private int value;

    public Object doProxy(AProxyChain proxyChain) {
        //do proxy business
        //执行后，重新执行代理链中的doProxyChain，执行的顺序从1->n
        System.out.println(value);
        proxyChain.doProxyChain();
        return null;
    }

    public AProxy(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}