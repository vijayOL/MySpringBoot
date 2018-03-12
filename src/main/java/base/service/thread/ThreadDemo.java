package base.service.thread;

/**
 * @Description:
 * @see: demo
 * @Date 2018/3/12 10:55
 * @Author Vijay Tang
 */
public class ThreadDemo implements Runnable{

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Thread a =new Thread(new ThreadDemo());
        a.start();
        Thread b=a;
        b.start();
    }
}
