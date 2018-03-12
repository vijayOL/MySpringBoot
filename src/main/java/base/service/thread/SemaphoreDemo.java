package base.service.thread;

import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @see: demo
 * @Date 2018/3/12 16:26
 * @Author Vijay Tang
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        int N=8;
        Semaphore semaphore=new Semaphore(5);
        for(int i=0;i<N;i++){
            new SemaphoreTask(i,semaphore).start();
        }
    }

    static class SemaphoreTask extends Thread{
        private  int num;

        private Semaphore semaphore;

        public SemaphoreTask(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"获取机器,开始生产");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
