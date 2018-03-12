package base.service.thread;

import sun.misc.GC;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @see: demo
 * @Date 2018/3/12 14:05
 * @Author Vijay Tang
 */
public class CountDownLatchDemo {

    static final CountDownLatch latch=new CountDownLatch(2);

    public static void main(String[] args) {
        new Thread(){
            @Override
            public  void run(){
                System.out.println("son thread:"+currentThread().getName()+" is running!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("son thread:"+currentThread().getName()+" is over!");
                latch.countDown();
            }
        }.start();

        new Thread(){
            @Override
            public  void run(){
                System.out.println("son thread:"+currentThread().getName()+" is running!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("son thread:"+currentThread().getName()+" is over!");
                latch.countDown();
            }
        }.start();


        System.out.println("waiting other son threads running out");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("other son threads over");
        System.out.println("main procedure running...");
    }
}
