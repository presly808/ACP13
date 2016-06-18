package ua.artcode.week5.threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by serhii on 18.06.16.
 */
public class TaskScheduler extends Thread {

    private volatile boolean active = true;

    private Runnable task;
    private long period;

    // blocking method
    public void accept(Runnable task, long millis){
        this.task = task;
        period = millis;

        start();
    }

    public void cancel(){
        active = false;
    }

    @Override
    public void run() {
        Thread lastThread = null;
        while(active){

            /*if(lastThread != null && lastThread.getState() == State.TERMINATED) {

            }*/

            lastThread = new Thread(task);
            lastThread.start();


            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
