package syncWaitNotify;

public class SyncWaitNotify {

    public void thread1() throws InterruptedException {
        Object sync = new Object();

        Thread t1 = new Thread(new Thread1(sync));
        Thread t2 = new Thread(new Thread2(sync));

        t1.start();
        Thread.sleep(100);
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Main: acabou");
    }

}
