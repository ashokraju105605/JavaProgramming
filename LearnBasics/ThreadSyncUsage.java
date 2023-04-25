package LearnBasics;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSyncUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
/**/
        new Thread(){  public void run(){  Table.printTable(1); } }.start();  
        new Thread(){  public void run(){  Table.printTable(10); } }.start();  
        new Thread(){  public void run(){  Table.printTable(100); } }.start();  
        new Thread( () -> {Table.printTable(1000);} ).start();
        
        Table1 obj = new Table1();//only one object    
        MyThread1 t1=new MyThread1(obj);    
        MyThread2 t2=new MyThread2(obj);    
        t1.start();    
        t2.start();
/* */        
        Semaphore semaphore = new Semaphore(3); // Creates a Semaphore with 3 permits
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Task(semaphore, i));
            threads[i].start();
        }
    }
}
class Table{  
  
    synchronized static  void printTable(int n){  
      for(int i=1;i<=10;i++){  
        System.out.println(n*i);  
        try{  
          Thread.sleep(400);  
        }catch(Exception e){}  
      }  
    }  
}

class Table1  
{      
 void printTable(int n){    
   synchronized(this){//synchronized block    
     for(int i=1;i<=5;i++){    
      System.out.println(n*i);    
      try{    
       Thread.sleep(400);    
      }catch(Exception e){System.out.println(e);}    
     }    
   }    
 }//end of the method    
}
class MyThread1 extends Thread{    
    Table1 t;    
    MyThread1(Table1 t){    
        this.t=t;    
    }    
    public void run(){    
        t.printTable(5);    
    }    
        
}    

// SEMAPHORE implementation.
// MUTEX IS LOCKING , SEMAPHORE IS SIGNALLING.

class MyThread2 extends Thread{    
    Table1 t;    
    MyThread2(Table1 t){    
        this.t=t;    
    }    
    public void run(){    
        t.printTable(3);    
    }    
}

class Task implements Runnable {
    private Semaphore semaphore;
    private int id;

    public Task(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    public void run() {
        try {
            semaphore.acquire(); // Acquires a permit from the semaphore
            System.out.println("Thread " + id + " ACQUIRED a permit");
            Thread.sleep(1000); // Simulates some work
            System.out.println("Thread " + id + " RELEASING a permit");
            semaphore.release(); // Releases the permit back to the semaphore
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LockExample {
    private Lock lock = new ReentrantLock();

    public void sharedResourceMethod() {
        lock.lock(); // acquire the lock
        try {
            // critical section - only one thread can access this code at a time
            // manipulate shared resource
            System.out.println("Jai Shree Ram");
        } finally {
            lock.unlock(); // release the lock
        }
    }
}

class Counter extends Thread {
 
    // Atomic counter Variable
    AtomicInteger count;
 
    // Constructor of class
    Counter()
    {
        count = new AtomicInteger();
    }
 
    // method which would be called upon
    // the start of execution of a thread
    public void run()
    {
 
        int max = 1_000_00_000;
 
        // incrementing counter total of max times
        for (int i = 0; i < max; i++) {
            count.addAndGet(1);
        }
    }
}

