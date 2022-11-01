package task02;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;
    private Integer count = 0;
    private final Integer amountOfCalls = new Random().nextInt(7) + 1;

    public MyCallable(String name) {
        this.name = name;
    }

    public MyCallable() {
    }

    @Override
    public Integer call() throws Exception {
        Thread.currentThread().setName(name);

        while (count < amountOfCalls) {
            count++;
            System.out.println("Hello from thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }

        }
        return count;
    }
}

