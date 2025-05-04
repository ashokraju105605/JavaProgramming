package LearnBasics;

import java.lang.Thread;

public class ThreadsUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        ThreadEx thr = new ThreadEx();
        thr.run(); // fine, but does not start a seperate call stack. runs in the context of main threads stack.
        // there is no context-switching because here t1 and t2 will be treated as normal object not thread object.

        ThreadEx thr1 = new ThreadEx();   
        thr1.start(); // starts a new thread and calls the run method in that thread.
        // The run method is executed in a separate call stack, allowing for context-switching between threads.

        RunnableTsk rTsk1 = new RunnableTsk(); 
        Thread thr2 = new Thread(rTsk1); // Thread is created but not started yet.
        // The thread is in the NEW state.
        thr2.start();
        new Thread(rTsk1).start();
        try {
            thr2.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // after the join below code executes.

        threadDetails();

        new Thread(new SleepThr()).start(); // generally runnable task is passed to the thread constructor.
    }
    public static void threadDetails()
    {
        Thread thr3 = new Thread("my first thread");
        thr3.start();
        thr3.setName("Ashok Thread");
        System.out.println(thr3.getName());
        System.out.println(thr3.getId());
        thr3.setDaemon(true);
        System.out.println("Deamon ? " + thr3.isDaemon());
        // The sole purpose of the daemon thread is that it provides services to user thread for background supporting task. 
        // If there is no user thread, why should JVM keep running this thread. 
        // That is why JVM terminates the daemon thread if there is no user thread
        System.out.println(Thread.currentThread().getName() +
                    " running with priority " + Thread.currentThread().getPriority());
        thr3.setPriority(Thread.MAX_PRIORITY); // takes values from 1 (low prio) -> 10 (high prio).
        System.out.println(Thread.currentThread().getName() +
                    " running with priority " + Thread.currentThread().getPriority());
        System.out.println(thr3.getState().name());
    }
}
class ThreadEx extends Thread
{
    public void run()
    {
        System.out.println("Thread from ThreadEx is running  " + Math.random());
    }
}
class RunnableTsk implements Runnable
{
    public void run()
    {
        try{
        Thread.sleep(2000);
        }
        catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }
        System.out.println("Thread from MUlti2 is running " + Math.random());
    }
}

class SleepThr extends Thread
{
    public void run()
    {
        System.out.println("Before sleep");

        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After sleep");
    }
}