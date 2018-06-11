import org.springframework.aop.framework.ProxyFactory;
import service.greet.IGreetServiceImpl;

public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new IGreetServiceImpl());
        proxyFactory.getProxy();
    }
}
