import aop.advice.GreetingAfterAdvice;
import aop.advice.GreetingBeforeAdvice;
import business.service.IGreetService;
import business.service.IGreetServiceImpl;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.framework.ProxyFactory;

public class Client {
    public static void main(String[] args)  {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new IGreetServiceImpl());
//        proxyFactory.addAdvice(new GreetingBeforeAdvice());
//        proxyFactory.addAdvice(new GreetingAfterAdvice());

        IGreetService proxy = (IGreetService) proxyFactory.getProxy();
        proxy.sayHello("jack");
    }
}
