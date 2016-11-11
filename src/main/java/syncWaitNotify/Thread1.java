package syncWaitNotify;

public class Thread1 implements Runnable {
    private static int count;
    private Object sync;

    public Thread1(Object sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        try {
            doIt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doIt() throws InterruptedException {
        synchronized (sync) {
            log("Sincronizando");

            log("wait");
            sync.wait(10000);

            log("notify");
            sync.notify();

            log("Acabou");
        }
    }

    private static void log(String s) {
        System.out.println("syncWaitNotify.Thread1: " + s);
    }

}
