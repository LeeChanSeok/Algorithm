import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> positive = new ArrayList<>();
		List<Integer> negative = new ArrayList<>();
		
		for(int i = 0; i < n ; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 0) positive.add(num);
			else if(num < 0) negative.add(-num);
		}
		
		Collections.sort(positive);
		Collections.sort(negative);
		
		int pSize = positive.size();
		int nSize = negative.size();
		
		long ans = 0;
		
		int idx = pSize - 1;
		while(idx >= 0) {
			ans += positive.get(idx);
			idx -= k;
		}
		
		idx = nSize - 1;
		while(idx >= 0) {
			ans += negative.get(idx);
			idx -= k;
		}
		
		System.out.println(ans * 2);
		
	}

}