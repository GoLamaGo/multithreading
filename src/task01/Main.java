package task01;

public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("main group of threads");

        MyThread myFirstThread = new MyThread(threadGroup, "First thread");
        MyThread mySecondThread = new MyThread(threadGroup, "Second thread");
        MyThread myThirdThread = new MyThread(threadGroup, "Third thread");
        MyThread myFourthThread = new MyThread(threadGroup, "Fourth thread");

        myFirstThread.start();
        mySecondThread.start();
        myThirdThread.start();
        myFourthThread.start();

        try {
            Thread.sleep(15000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        threadGroup.interrupt();
    }
}
