import aop.advice.GreetingAfterAdvice;
import aop.advice.GreetingBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import service.greet.IGreetService;
import service.greet.IGreetServiceImpl;

public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new IGreetServiceImpl());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());

        IGreetService proxy = (IGreetService) proxyFactory.getProxy();
        proxy.greet("jack");
    }
}
