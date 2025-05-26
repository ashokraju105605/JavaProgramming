package LearnBasics;

import java.util.*;

public class QueueUsage {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        // Queue is just an interface, PriotiryQueue is an implementation.
        Queue<String> pq = new PriorityQueue<String>();
        pq.add("ashok");
        pq.add("raju");
        pq.add("ananya");
        pq.offer("test");

        System.out.println(pq);

        for(String s: pq)
        {
            System.out.println(s);
        }

        Iterator<String> it = pq.iterator();
        while(it.hasNext())
        {
            String temp = it.next();
            System.out.println(temp);
        }

        System.out.println(pq.peek()); // returns the head of the queue, throws exception if empty.
        System.out.println(pq.remove()); // returns the head of the queue, throws exception if empty.
        System.out.println(pq.poll()); // poll() will return null if queue is empty.
        System.out.println(pq.element()); // returns the head of the queue, throws exception if empty.
        System.out.println(pq.offer("rama")); // returns true if added successfully at the end of the queue.
        System.out.println(pq.isEmpty());
        System.out.println(pq);

        /*
        The elements in PriorityQueue must be of Comparable type. String and Wrapper classes are Comparable by default. 
        To add user-defined objects in PriorityQueue, you need to implement Comparable interface. 
        */

        Book b1=new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);  
        Book b2=new Book(233,"Operating System","Galvin","Wiley",6);  
        Book b3=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  

        Queue<Book> queue=new PriorityQueue<Book>();  

        queue.add(b1);
        queue.add(b2);
        queue.add(b3);

        for(Book b:queue)
        {
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity); 
        }
        queue.remove();
        for(Book b:queue)
        {
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity); 
        }

        ArrayList<Book> al = new ArrayList<Book>();
        al.add(b1);al.add(b2);al.add(b3);
        Collections.sort(al, new BookComparator()); // sort the list using comparator.
        // Collections.sort(al); // sort the list using comparable.
        al.sort(new BookComparator());
        
        Comparator<Book> comp = Comparator.comparing((Book b)-> b.id); // lambda comparator
        Collections.sort(al,comp);

        Collections.sort(al,(Book b, Book bb)-> b.id-bb.id); // sort the list using lambda expression

        System.out.println();
        for(Book b:al)
        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);

        // DOUBLE ENDED QUEUE with Linked List
        Queue<String> llq = new LinkedList<>(); // LinkedList implements Queue interface.
        llq.add("ashok"); // add() will throw exception if queue is full.
        llq.offer("raju"); // offer() will return false if queue is full.
        System.out.println( llq.poll());
        System.out.println(llq);
        System.out.println(llq.peek());

        testing();
    }

    static class Book implements Comparable<Book>{
        // Comparable has to implement compareTo method.
        // It takes one object and returns an int value.  
        // It is used to sort the objects in the collection when no explicit comparator is provided.
        int id;  
        String name,author,publisher;  
        int quantity;  
        public Book(int id, String name, String author, String publisher, int quantity) {  
            this.id = id;  
            this.name = name;  
            this.author = author;  
            this.publisher = publisher;  
            this.quantity = quantity;  
        }  
        public int compareTo(Book b) {  
            if(id>b.id){  
                return 1;  
            }else if(id<b.id){  
                return -1;  
            }else{  
            return 0;  
            }  
        }  
        
    }
    static class BookComparator implements Comparator<Book>{  
        // Comparator has to implement compare method.
        // It takes two objects and returns an int value.
        // create a new comparator object and pass it to the sort method.
        public int compare(Book b1,Book b2){  
          
        if(b1.id<b2.id)  
            return -1;  
        else if(b1.id>b2.id)
            return 1;  
        else
            return 0;
        }
    }
    public static void testing()
    {
        Queue<Integer> deq_ll = new LinkedList<Integer>();
        Queue<Integer> deq_arr = new ArrayDeque<Integer>(2);
        Queue<Integer> pq = new PriorityQueue<Integer>(5); // minHeap with size 5.

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(Comparator.reverseOrder()); // Collection.reverseOrder() internally calls Comparator.reverseOrder().
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // default is minHeap.
        
        // Returns null if no elements are present.
        System.out.println(deq_ll.poll());

        // Returns java.util.NoSuchElementException Exception.
        //System.out.println(deq_ll.remove());

        pq.add(2);
        pq.add(2);
        System.out.println(pq.poll());
        
    }    
}
