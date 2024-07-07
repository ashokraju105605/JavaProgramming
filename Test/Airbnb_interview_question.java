import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findRoot' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY nodes as parameter.
     */
    public static class BSTNode
    {
        public int value;
        public BSTNode left;
        public BSTNode right;
        BSTNode(int value)
        {
            this.value = value;
            left = null;
            right = null;
        }
    }
    public static int findRoot(List<List<Integer>> nodes) {
        if(nodes == null || nodes.size() == 0 ) return -1;
        
        HashSet<Integer> hs = new HashSet<Integer>();
        HashMap<Integer, BSTNode> hn = new HashMap<>();
        HashMap<Integer,Integer> hp = new HashMap<>();
        
        for(List<Integer> a: nodes)
        {
            if(!hs.contains(a.get(0)))
                hs.add(a.get(0));
            else
                return -1;
                
            hn.put(a.get(0), new BSTNode(a.get(0)));
        }
        
        for(List<Integer> a: nodes)
        {
            if(a.get(1)!=-1 && hn.containsKey(a.get(1)) && !hp.containsKey(a.get(1)))
                hp.put(a.get(1),a.get(0));
            else
                return -1;
            if(a.get(2)!=-1 && hn.containsKey(a.get(2)) && !hp.containsKey(a.get(2)))
                hp.put(a.get(2),a.get(0));
            else
                return -1;
        }
        
        for(List<Integer> a: nodes)
        {
              BSTNode t = hn.get(a.get(0));
              t.left = hn.get(a.get(1));
              t.right = hn.get(a.get(2));  
        }
        
        // easy imlementation would be to check for nodes that doesn't have a parent to be the roots
        // if more than one root then return -1 or else check for bst on single node.
        int result = -1;
        HashSet<Integer> roots = new HashSet<>();
        for(Integer n: hn.keySet())
        {
            if(roots.contains(n))
                roots.remove(n);
                
            if(hp.containsKey(n))
            {
                int h = hp.get(n);
                roots.add(h);
                result = h;
            }
        }
        
        Set<Integer> ns = hn.keySet();
        if(!isBST(hn.get(result),ns) || ns.size() > 0 )
            return -1;
        
        
        return result;
    }
    public static boolean isBST(BSTNode n, Set<Integer> ns)
    {

        // wrong implementation, should need to check the range, not compare against immediate root data.
        if(n==null)
            return true;
        ns.remove(n.value);
        
        if(n.left!=null && n.right !=null)
        {
            return (n.value>n.left.value && isBST(n.left,ns)) && (n.value<n.right.value && isBST(n.right,ns)) ;   
        }
        if(n.left !=null)
            return (n.value>n.left.value && isBST(n.left,ns) );
            
        if(n.right !=null)
            return (n.value<n.right.value && isBST(n.right,ns));
         
         return true;   
    }

}

public class Airbnb_interview_question {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int nodesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int nodesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> nodes = new ArrayList<>();

        IntStream.range(0, nodesRows).forEach(i -> {
            try {
                nodes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.findRoot(nodes);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
