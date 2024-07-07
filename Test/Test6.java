import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class Test6 {
	public int numMatchingSubseq(String s, String[] words) {
		AtomicInteger x = new AtomicInteger();
		Map<String, Integer> mp = new HashMap<>();
		Arrays.stream(words).forEach(word ->{
			mp.put(word, mp.getOrDefault(word, 0) + 1);
		});
		int n = s.length();
		mp.keySet().stream().parallel().forEach(word ->{
			int m = word.length(), j = 0;
			for(int i = 0; i < n; i++){
				if(j == m){
					break;
				}
				if(s.charAt(i) == word.charAt(j)){
					j++;
				}
			}
			if(j == m){
				x.addAndGet(mp.get(word));
			}
		});

		return x.intValue();
	}
}