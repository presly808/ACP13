package ua.artcode.week5.producer_consumer;

import java.util.Queue;

/**
 * Created by serhii on 19.06.16.
 */
public class MyBlockingQueue {

    private Object[] array;
    private int size;
    private Object monitor = new Object();

    public MyBlockingQueue(int capacity) {
        array = new Object[capacity];
    }

    public void add(Object el) {
        synchronized (monitor) {
            while (size == array.length) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            array[size] = el;
            size++;

            monitor.notifyAll();
        }
    }


    public Object remove() {
        synchronized (monitor) {

            while (size == 0) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            size--;
            monitor.notifyAll();
            return array[size];
        }
    }

    public int getSize() {
        return size;
    }

}
