package service.greet;

public class IGreetServiceImpl implements IGreetService {
    @Override
    public void greet(String name) {
        System.out.println("hello, " + name);
    }
}
