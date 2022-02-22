package task1;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        System.out.printf("Thread \"%s\" is created\n", getName());
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.printf("Thread \"%s\" is working\n", getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.printf("Thread \"%s\" is interrupted while sleeping\n", getName());
                interrupt();
                break;
            }

        }
        System.out.printf("Thread \"%s\" is interrupted\n", getName());
    }

}