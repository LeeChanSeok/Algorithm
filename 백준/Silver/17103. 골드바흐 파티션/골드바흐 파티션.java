import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int MAX = 1000000;
	static boolean[] prime = new boolean[MAX + 1];
	static ArrayList<Integer> primeList;
	static int N;
	
	public static void main(String[] args) throws Exception {

		input();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			pro();
		}
		System.out.println(sb);
	}

	private static void pro() {
		
		int L = 0, R = primeList.size() - 1;
		
		int ans = 0;
		while(L <= R) {
			int sum = primeList.get(L) + primeList.get(R);
			
			if(sum == N) {
				++ans;
				++L;
			}else if(sum < N) ++L;
			else --R;
		}
		
		sb.append(ans).append('\n');
		
	}

	private static void input() {
		
		primeList = new ArrayList<>();
		find_prime();
		
	}

	private static void find_prime() {
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(MAX); ++i) {
			if(prime[i]) continue;
			
			for(int j = i*i; j <= MAX; j = j + i) prime[j] = true;
		}
		
		for(int i = 2; i <= MAX; ++i) {
			if(!prime[i]) primeList.add(i);
		}
		
	}

}