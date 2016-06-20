package ua.artcode.week5.producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by serhii on 19.06.16.
 */
public class MyBlockingQueueLocks {

    private Object[] array;
    private int size;
    private Lock lock = new ReentrantLock();
    private Condition addCondition = lock.newCondition();
    private Condition removeCondition = lock.newCondition();

    public MyBlockingQueueLocks(int capacity) {
        array = new Object[capacity];
    }

    public void add(Object el) {
        lock.lock();
        try {
            while (size == array.length) {
                try {
                    addCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            array[size] = el;
            size++;

            removeCondition.signal();
        } finally {
            lock.unlock();
        }
    }


    public Object remove() {
        lock.lock();
        try {

            while (size == 0) {
                try {
                    removeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            size--;
            addCondition.signal();
            return array[size];
        } finally {
            lock.unlock();
        }
    }

    public int getSize() {
        return size;
    }

}
