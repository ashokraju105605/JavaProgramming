package LearnBasics;

public class GarbageCollection {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        System.gc(); // Requesting JVM to run Garbage Collector
        // Note: The JVM does not guarantee that the garbage collector will run immediately or at all.
        // It is a suggestion to the JVM to free up memory by removing objects that are no longer reachable.
        // The garbage collector will automatically reclaim memory from objects that are no longer referenced.
    }
}
