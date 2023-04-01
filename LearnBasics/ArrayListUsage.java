package LearnBasics;


import java.util.*;
import java.io.*;

public class ArrayListUsage {
    public static void main(String[] args)
    {
        ArrayList<String> al = new ArrayList<String>();
        System.out.println("Jai Shree Ram");
        al.add("ashok");
        System.out.println(al.size());
        al.add("raju");
        System.out.println(Arrays.toString(al.toArray()));
        ArrayList<String> al2 =  new ArrayList<String>();
        al2.add("Gadhiraju");
        al.addAll(2, al2);
        System.out.println(Arrays.toString(al.toArray()));
        System.out.println(al.isEmpty());
        System.out.println(al.contains("Gadhiraju"));
        System.out.println(al.get(2));
        System.out.println(al.indexOf("Gadhiraju"));
        System.out.println(al.set(1, "Raju"));
        System.out.println(Arrays.toString(al.toArray()));
        System.out.println(al.remove(1));
        System.out.println(Arrays.toString(al.toArray()));

        Iterator<String> it = al.iterator();

        while(it.hasNext())
            System.out.println(it.next());

        for(String t: al)
        {
            System.out.println(t);
        }
        al.add("Ananya");
        System.out.println(al.toString());
        Collections.sort(al);
        System.out.println(al.toString());

        Student s1=new Student(101,"Rama",23);  
        Student s2=new Student(102,"Sita",21);  
        Student s3=new Student(103,"Laxmana",25); 
        ArrayList<Student> al3=new ArrayList<Student>();  
        al3.add(s1);//adding Student class object  
        al3.add(s2);  
        al3.add(s3); 

        for( int i=0;i<al3.size();i++)
        {
            System.out.println(al3.get(i).name);
        }

        for(Student s: al3)
        {
            System.out.println(s.name + " " + s.age + " " + s.rollno);
        }

        al3.forEach(s -> System.out.println(s.name + "-- " + s.age + "-- " + s.rollno));


        try  
        {  
            //Serialization  
            FileOutputStream fos=new FileOutputStream("file");  
            ObjectOutputStream oos=new ObjectOutputStream(fos);  
            oos.writeObject(al);  
            fos.close();  
            oos.close();  
            //Deserialization  
            FileInputStream fis=new FileInputStream("file");  
            ObjectInputStream ois=new ObjectInputStream(fis);  
            ArrayList<String>  list = (ArrayList<String>) ois.readObject();
            ois.close();
            fis.close();  
            System.out.println(list);    
        }catch(Exception e)  
        {  
            System.out.println(e);  
        } 

    }

    static class Student{  
        int rollno;  
        String name;  
        int age;  
        Student(int rollno,String name,int age){  
         this.rollno=rollno;  
         this.name=name;  
         this.age=age;  
        }  
    } 
}
