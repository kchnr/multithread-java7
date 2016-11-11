package multiThread;

public class MultiThread {
    public MultiThread() {
    }

    public void doIt() throws InterruptedException {
        System.out.println("Antes");

        Thread t1 = new Thread(new MyThread1());
        t1.start();
        Thread t2 = new Thread(new MyThread2());
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Depois");
    }

    private class MyThread1 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1);
                System.out.println("1");
                Thread.sleep(1);
                System.out.println("2");
                Thread.sleep(1);
                System.out.println("3");
                Thread.sleep(1);
                System.out.println("4");
                Thread.sleep(1);
                System.out.println("5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class MyThread2 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1);

                System.out.println("6");
                Thread.sleep(1);
                System.out.println("7");
                Thread.sleep(1);
                System.out.println("8");
                Thread.sleep(1);
                System.out.println("9");
                Thread.sleep(1);
                System.out.println("10");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
