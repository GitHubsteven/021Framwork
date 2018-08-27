package thread.local;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/27
 * @Time: 19:13
 * @Description:
 * @version: 1.0.0
 */
public class SequenceB implements Sequence {
    private static ThreadLocal<Integer> seqContainer = ThreadLocal.withInitial(() -> 0);

    @Override
    public int getNumber() {
        Integer seq = seqContainer.get();
        seqContainer.set(seq + 1);
        return seq;
    }
}