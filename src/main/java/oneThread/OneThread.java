package oneThread;

public class OneThread {
    public OneThread() {
    }

    public void doIt() throws InterruptedException {
        System.out.println("Antes");

        Thread t = new Thread(new MyThread());

        t.start();

        t.join();

        System.out.println("Depois");
    }

    private class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("1");
                System.out.println("2");
                Thread.sleep(2000);
                System.out.println("3");
                System.out.println("4");
                Thread.sleep(2000);
                System.out.println("5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
