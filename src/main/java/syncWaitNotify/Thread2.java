package syncWaitNotify;

public class Thread2 implements Runnable {
    private static int count;
    private final Object sync;

    public Thread2(Object sync) {
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

            log("notify");
            sync.notifyAll();

            log("wait");
            sync.wait(10000);

            log("Acabou");
        }
    }

    private static void log(String s) {
        System.out.println("syncWaitNotify.Thread2: " + s);
    }

}
