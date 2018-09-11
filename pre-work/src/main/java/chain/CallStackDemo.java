package chain;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/11
 * @Time: 16:38
 * @Description:
 * @version: 1.0.0
 */
public class CallStackDemo {
    public static void main(String[] args) {
        int a=0,b=1;
        new CallStackDemo().method1(b);
        System.out.println("End of main");
    }
    public void method1(int b){
        System.out.println("In method1. Value recieved : "+b);
        method2(b);
    }
    public void method2(int b){
        System.out.println("In method2. Value recieved : "+b);
        method3();
    }
    public void method3(){
        System.out.println("In method3");
    }
}