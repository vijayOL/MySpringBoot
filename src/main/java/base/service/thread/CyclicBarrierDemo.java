package base.service.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @see: demo
 * @Date 2018/3/12 15:19
 * @Author Vijay Tang
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(5,new MainMethod());
        new Tasks(barrier,"A").start();
        new Tasks(barrier,"B").start();
        new Tasks(barrier,"C").start();
        new Tasks(barrier,"D").start();
        new Tasks(barrier,"E").start();
    }

    static class MainMethod implements Runnable{

        @Override
        public void run() {
            System.out.println("终于等到主方法运行了！");
        }
    }

    static class Tasks extends Thread{
        private CyclicBarrier barrier;
        private String name;

        public Tasks(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("线程:"+name+"开始执行..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程:"+name+"执行完毕，通知障碍器");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
