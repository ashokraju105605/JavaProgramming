import java.util.TreeMap;

public class Test7 {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
    }
}
class RLEIterator {
    TreeMap<Long, Integer> treeMap;
    long curr=-1;

    public RLEIterator(int[] encoding) {
        treeMap = new TreeMap<>();
        long idx=-1;
        for(int i=0;i<encoding.length;i=i+2){
            if(encoding[i]!=0){
                idx+=encoding[i];
                int num = encoding[i+1];
                treeMap.put(idx, num);
            }
        }
    }

    public int next(int n) {
        curr+=n;
        return treeMap.ceilingKey(curr)==null ? -1 : treeMap.ceilingEntry(curr).getValue();
    }
}