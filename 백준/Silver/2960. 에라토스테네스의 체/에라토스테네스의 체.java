import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int ans;
	static int[] prime;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {

		int k = 0;
		for(int i = 2; i <= N; ++i) {
			if(prime[i] != 0) continue;
			for(int j = i; j <= N; j = j + i) {
				if(prime[j] == 0) prime[j] = ++k;
			}
		}

		for(int i = 2; i <= N; ++i) {
			if(prime[i] == K) ans = i;
		}
		
		System.out.println(ans);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		prime = new int[N+1];
		
	}

}