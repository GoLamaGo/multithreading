package task01;

import java.util.Random;

public class MyThread extends Thread {

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {

        while (true) {
            try {
                if (isInterrupted()) return;
                System.out.println("Hi from " + getName());
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                System.out.println(getName() + " thread is terminated");
                interrupt();
                break;
            }
        }
    }
}
