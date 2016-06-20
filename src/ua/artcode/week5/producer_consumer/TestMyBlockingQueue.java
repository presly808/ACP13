package ua.artcode.week5.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by serhii on 19.06.16.
 */
public class TestMyBlockingQueue {


    public static void main(String[] args) {
        MyBlockingQueueWrapper myBlockingQueue = new MyBlockingQueueWrapper(10);

        final int count = 10000;

        ExecutorService executorService = Executors.newFixedThreadPool(80);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 40; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        myBlockingQueue.add(1);
                    }
                }
            });
        }


        for (int i = 0; i < 40; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        myBlockingQueue.remove();
                    }
                }
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){

        }


        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println(myBlockingQueue.getSize());

    }
}
