import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int MOD = 1000000000;
		
		int[] D = new int[N+1];
		D[1] = 1;
		
		for(int i = 2; i <= N; ++i) {
			if(i % 2 == 1) {
				D[i] = D[i-1];
			} else {
				D[i] = (D[i-1] + D[i/2]) % MOD;
			}
		}
		
		System.out.println(D[N]);

	}

}