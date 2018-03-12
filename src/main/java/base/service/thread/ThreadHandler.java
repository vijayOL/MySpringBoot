package base.service.thread;

/**
 * @Description:线程
 * @see: demo
 * @Date 2018/3/8 10:37
 * @Author Vijay Tang
 */
public class ThreadHandler implements Runnable{
    
    private String name;

    private Object prev;

    private Object self;

    public ThreadHandler(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run(){
        int i=10;
        while (i>0){
            synchronized (prev){
                synchronized (self){
                    System.out.print(name);
                    i--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) throws InterruptedException{
        Object a=new Object();
        Object b=new Object();
        Object c=new Object();
        
        ThreadHandler A=new ThreadHandler("A",c,a);
        ThreadHandler B=new ThreadHandler("B",a,b);
        ThreadHandler C=new ThreadHandler("C",b,c);
        
        new Thread(A).start();
        Thread.sleep(100);
        new Thread(B).start();
        Thread.sleep(100);
        new Thread(C).start();
        Thread.sleep(100);

    }

}
