package task02;

import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger overallAmountOfCalls = new AtomicInteger();

        Callable<Integer> myCallable1 = new MyCallable("Thread #1");
        Callable<Integer> myCallable2 = new MyCallable("Thread #2");
        Callable<Integer> myCallable3 = new MyCallable("Thread #3");
        Callable<Integer> myCallable4 = new MyCallable("Thread #4");

        ExecutorService pool = Executors.newFixedThreadPool(4);

        var stringFutureTaskAll = pool.invokeAll(Set.of(myCallable1, myCallable2, myCallable3, myCallable4));
        var stringFutureTaskAny = pool.invokeAny(Set.of(myCallable1, myCallable2, myCallable3, myCallable4));

        pool.shutdown();

        stringFutureTaskAll.forEach(integerFuture -> {
            try {
                int amount = integerFuture.get();
                overallAmountOfCalls.addAndGet(amount);
                System.out.print(amount + " ");
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            } finally {
            }
        });

        System.out.println("The result of the fastest thread is : " + stringFutureTaskAny);
        System.out.println("Overall amount of calls are: " + overallAmountOfCalls);

    }

}
