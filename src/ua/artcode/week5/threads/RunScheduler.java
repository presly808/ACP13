package ua.artcode.week5.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by serhii on 18.06.16.
 */
public class RunScheduler {

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();

        taskScheduler.accept(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
            }
        }, 1000);

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        taskScheduler.cancel();

        Executor executor = Executors.newFixedThreadPool(10);

    }
}
