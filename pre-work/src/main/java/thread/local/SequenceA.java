package thread.local;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/23
 * @Time: 20:03
 * @Description:
 * @version: 1.0.0
 */
public class SequenceA implements Sequence {
    private static int number = 0;

    @Override
    public int getNumber() {
        number = number + 1;
        return number;
    }

}