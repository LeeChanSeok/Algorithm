import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static Map<Character, Integer> index = new HashMap<>();
	static int N, ans;
	static String block;
	static int[] D;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
	}

	private static void pro() {

		D[0] = 0;
		for(int i = 0; i < N-1; ++i) {
			int cur = index.get(block.charAt(i));
			
			for(int j = i + 1; j < N; ++j) {
				
				int next = index.get(block.charAt(j));
				if(next == (cur + 1) % 3) {
					
					D[j] = Math.min(D[j], D[i] + (int)Math.pow(j - i, 2));
				}
			}
			
		}

		ans = D[N-1];
		if(ans == 987654321) ans = -1;
		System.out.println(ans);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		block = br.readLine();
				
		D = new int[N];
		Arrays.fill(D, 987654321);
		
		index.put('B', 0);
		index.put('O', 1);
		index.put('J', 2);
	}
}