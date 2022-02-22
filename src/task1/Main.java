package task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 4;
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup");
        MyThread[] threads = new MyThread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new MyThread(threadGroup, "number " + (i + 1));
            Thread.sleep(1000);
        }

        for (MyThread thread : threads) {
            thread.start();
            Thread.sleep(500);
        }

        Thread.sleep(1500);

        threadGroup.interrupt();

    }
}
