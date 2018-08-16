package business.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/16
 * @Time: 19:35
 * @Description:
 * @version: 1.0.0
 */
public class IGreetServiceImpl implements IGreetService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello," + name);
    }
}