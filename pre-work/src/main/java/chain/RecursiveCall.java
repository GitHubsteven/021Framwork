package chain;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/11
 * @Time: 16:42
 * @Description:
 * @version: 1.0.0
 */
public class RecursiveCall {
    public static void main(String[] args) {
        int total = 0;
        int first = 10;
        for (int x = 0; x < first; x++) {
            int n = 1000000;
            long start = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                l(10);
            }
            total += (System.currentTimeMillis() - start);
        }
        System.out.println("average:" + total / first);

    }

    public static int r(int x) {
        if (x == 1) return 1;
        return x * r(x - 1);
    }

    public static int l(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}