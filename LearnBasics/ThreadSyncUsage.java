package LearnBasics;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSyncUsage {
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Jai Shree Ram");
/**/
        new Thread(){  public void run(){  Table.printTable(1); } }.start();  
        new Thread(){  public void run(){  Table.printTable(10); } }.start();  
        new Thread(){  public void run(){  Table.printTable(100); } }.start();  
        new Thread( () -> {Table.printTable(1000);} ).start();
        
        Table1 objt1 = new Table1();//only one object    
        MyThread5 t5=new MyThread5(objt1);    
        MyThread3 t3=new MyThread3(objt1);    
        t5.start();    
        t3.start();
/* */        
        Semaphore semaphore = new Semaphore(3); // Creates a Semaphore with 3 permits
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Work(semaphore, i));
            threads[i].start();
        }

        
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };
        Thread t3 = new Thread(task);
        t3.start();
        t3.join();

    }
}
class Table{  
    // synchronized static method works on class level, not on object level.
    // ensure thread safety by locking the class-level monitor, rather than an instance-level lock.
    // Java locks the class (ClassName.class) instead of a specific object instance.
    // Other static methods in the same class cannot execute while one is locked.
    // Avoid overusing synchronized static, as it locks the entire class.
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
    // synchronized(this) is used to lock the current object for any other thread.    
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

// SEMAPHORE implementation.
// MUTEX IS LOCKING , SEMAPHORE IS SIGNALLING.
// The class itself becomes a thread by inheriting the Thread class. 
// ✔ You override the run() method to define thread behavior. 
// ✔ Allows direct access to thread methods (start(), sleep(), etc.).
// ✔ Simpler for small tasks or when you don't need to share the thread class with other classes.
// ✔ Less flexible for thread management (e.g., using thread pools).
class MyThread5 extends Thread{    
    Table1 t;    
    MyThread5(Table1 t){    
        this.t=t;    
    }    
    public void run(){    
        t.printTable(5);    
    }    
        
}    

class MyThread3 extends Thread{    
    Table1 t;    
    MyThread3(Table1 t){    
        this.t=t;    
    }    
    public void run(){    
        t.printTable(3);    
    }    
}

// The class implements Runnable and defines the run() method. 
// ✔ You create a Thread object and pass an instance of the class implementing Runnable. 
// ✔ Allows better separation of concerns—you can extend another class while running threads.
// ✔ More flexible for thread management (e.g., using thread pools).
// ✔ You can share the same instance of the Runnable class among multiple threads.
// ✔ You can pass parameters to the constructor of the Runnable class.
// ✔ You can implement multiple interfaces in the class.
class Work implements Runnable {
    // This class implements the Runnable interface, allowing it to be run by a thread.
    private Semaphore semaphore;
    private int id;

    public Work(Semaphore semaphore, int id) {
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
    private Lock lock = new ReentrantLock(true); // can be relocked on top of lock, and same times unlock needs to happen.

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
    AtomicInteger atmInt; // AtomicInteger is a class that provides an integer value that may be updated atomically.
 
    // Constructor of class
    Counter()
    {
        atmInt = new AtomicInteger();
    }
 
    // method which would be called upon
    // the start of execution of a thread
    public void run()
    {
 
        int max = 1_000_00_000;
        atmInt.getAndSet(2); // set the initial value to 2
 
        // incrementing counter total of max times
        for (int i = 0; i < max; i++) {
            atmInt.addAndGet(1); // increment the counter by 1
        }
        System.out.println("Final count value: " + atmInt.get()); // print the final count value
    }
}

