import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		int one = 0;
		
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 1) plus.add(num);
			else if (num == 1) ++one;
			else minus.add(num);
		}
		
		Collections.sort(plus, (p1, p2) -> p2 - p1);
		Collections.sort(minus);

		int res = 0;
		for(int s = 0, e = minus.size() - 1; s < e; s += 2) {
			res += (minus.get(s) * minus.get(s+1));
		}
		if(minus.size() % 2 == 1) res += minus.get(minus.size() - 1);
		
		res += one;
		
		for(int s = 0, e = plus.size() - 1; s < e; s += 2) {
			res += (plus.get(s) * plus.get(s+1));
		}
		if(plus.size() % 2 == 1) res += plus.get(plus.size() - 1);
		
		System.out.println(res);
	}

}