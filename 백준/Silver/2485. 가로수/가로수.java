import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] trees = new Integer[N];
		
		for(int i = 0; i < N; ++i) trees[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(trees);
		
		Map<Integer, Integer> diff_Cnt = new TreeMap<>((k1, k2) -> k1 - k2);
		int diff;
		for(int i = 1; i < N; ++i) {
			diff = trees[i] - trees[i-1];
			diff_Cnt.put(diff, diff_Cnt.getOrDefault(diff, 0) + 1);
		}
		
		Set<Integer> keyset = diff_Cnt.keySet();
		
		int end = keyset.iterator().next();
		int max = 1;
		boolean isDivide;
		for(int i = 2; i <= end; ++i) {
			isDivide = true;
			for(int key : keyset) {
				if(key % i != 0) {
					isDivide = false;
					break;
				}
			}
			if(isDivide) max = i;
		}
		
		int key, value;
		int answer = 0;
		for(Entry<Integer, Integer> entry : diff_Cnt.entrySet()) {
			answer += (entry.getKey()/max-1)*entry.getValue();
		}
		
		System.out.println(answer);

	}
	
}

