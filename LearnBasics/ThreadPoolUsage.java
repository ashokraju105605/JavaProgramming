package LearnBasics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUsage {
    public static void main(String[] args) {
        // Create a thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit 10 tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            executor.submit(new Task(i));
        }

        for (int i = 0; i < 10; i++) {  
            Runnable worker = new Task(i+10);  
            executor.execute(worker);//calling execute method of ExecutorService  
        }

        // Shutdown the thread pool after all tasks are complete
        executor.shutdown();
    }

    static class Task implements Runnable {
        private int taskId;

        public Task(int id) {
            this.taskId = id;
        }

        @Override
        public void run() {
            System.out.println("Task #" + taskId + " is being executed by " + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }

        /*
         * when a thread throws the exception and the pool class is not able to catch this exception, 
         * then the thread exits and reduces the thread pool size by 1. 
         * If the same thing repeats a number of times, then there are fair chances that the pool will become empty, and hence, 
         * there are no threads available in the pool for executing other requests.
         * 
         * 
         * 
         * A lot of time is wasted in context switching among threads when the size of the thread pool is very large. 
         * Whenever there are more threads than the optimal number may cause the starvation problem, and it leads to resource thrashing
         * 
         * 
         * The accurate size of a thread pool is decided by the number of available processors and the type of tasks the threads have to execute. 
         * If a system has the P processors that have only got the computation type processes, 
         * then the maximum size of the thread pool of P or P + 1 achieves the maximum efficiency. 
         * However, the tasks may have to wait for I/O, and in such a scenario, 
         * one has to take into consideration the ratio of the waiting time (W) and the service time (S) for the request; 
         * resulting in the maximum size of the pool P * (1 + W / S) for the maximum efficiency.
         */
    }
}
