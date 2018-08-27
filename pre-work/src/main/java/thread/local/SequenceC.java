package thread.local;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/27
 * @Time: 19:31
 * @Description:
 * @version: 1.0.0
 */
public class SequenceC implements Sequence {
    private static MyThreadLocal<Integer> seqContainer = new MyThreadLocal<Integer>() {
        @Override
        protected Integer initValue() {
            return 0;
        }
    };

    @Override
    public int getNumber() {
        Integer seq = seqContainer.get();
        seqContainer.set(seq + 1);
        return seq;
    }
}