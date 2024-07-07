import java.util.HashMap;
import java.util.Map;

public class Test8 {
    public static void main(String[] args)
    {
        System.out.println("Jai Shree Ram");
        Test8 t8 = new Test8();
        Test8.Solution1 t8s =t8.new Solution1();
        boolean result = t8s.differByOne(new String[]{"abcd","acbd", "aacd"});
        System.out.println(result);
    }
    public class Solution1 {
        public boolean differByOne(String[] dict) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < dict.length; i++) {
            String str = dict[i];
                for (int j = 0; j < str.length(); j++) {
                    String s1 = str.substring(0, j);
                    String s2 = str.substring(j + 1);
                    String s = s1 + "*" + s2;
                    if (map.containsKey(s)) {
                        return true;
                    }
                    
                    map.put(s, 1);
                }
            }
            return false;
        }
    }
}

