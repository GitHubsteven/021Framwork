package thread.local;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/23
 * @Time: 20:00
 * @Description:
 * @version: 1.0.0
 */
public class ClientThread extends Thread {
    private Sequence sequence;

    ClientThread(Sequence seq) {
        this.sequence = seq;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "=>" + sequence.getNumber());
        }
    }
}