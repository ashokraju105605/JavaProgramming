package LearnBasics;

// Java program to show working of user defined
// Generic classes
 
// We use < > to specify Parameter type
class Test<Tk> {
    // An object of type T is declared
    Tk obj;
    Test(Tk obj) { this.obj = obj; } // constructor
    public Tk getObject() { return this.obj; }
}
class Test1<T, U>
{
    T obj1;  // An object of type T
    U obj2;  // An object of type U
 
    // constructor
    Test1(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
 
    // To print objects of T and U
    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
 
// Driver class to test above
public class GenericsUsage {
    public static void main(String[] args)
    {
        // instance of Integer type
        Test<Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());
 
        // instance of String type
        Test<String> sObj
            = new Test<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());

                Test1 <String, Integer> obj =
            new Test1<String, Integer>("GfG", 15);
 
        obj.print();


        // Calling generic method with Integer argument
        genericDisplay(11);
 
        // Calling generic method with String argument
        genericDisplay("GeeksForGeeks");
 
        // Calling generic method with double argument
        genericDisplay(1.0);

        /*
         * When we declare an instance of a generic type, the type argument passed to the type parameter 
         * must be a reference type. We cannot use primitive data types like int, char.

            Test<int> obj = new Test<int>(20); 
         */
    }


        // A Generic method example
    static <T> void genericDisplay(T element)
    {
        System.out.println(element.getClass().getName()
                           + " = " + element);
    }
}