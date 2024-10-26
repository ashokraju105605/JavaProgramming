import java.util.*;
public class sparsematrix {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        Map<List<Integer>, Integer> mat = new HashMap<>();

        mat.put(new ArrayList<>(Arrays.asList(2,4)),1);
        mat.put(new ArrayList<>(Arrays.asList(1,4)),5);

        System.out.println(mat.get(new ArrayList<>(Arrays.asList(2,4))));
        System.out.println(mat.get(new ArrayList<>(Arrays.asList(1,4))));
        System.out.println(mat.get(new ArrayList<>(Arrays.asList(2,3))));

        mat.put(new ArrayList<>(Arrays.asList(2,4)),9);

        System.out.println(mat.get(new ArrayList<>(Arrays.asList(2,4))));

        mat.remove(new ArrayList<>(Arrays.asList(2,4)));

        System.out.println(mat.get(new ArrayList<>(Arrays.asList(2,4))));

        mat.put(new ArrayList<>(Arrays.asList(2,4)),11);

        System.out.println(mat.get(new ArrayList<>(Arrays.asList(4,2))));



    }
    
}
