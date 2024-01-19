import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n1 = 123456;
		int n2 = n1 * 2;
		boolean[] prime = new boolean[n2 + 1];
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(n2); ++i) {
			if(prime[i]) continue;
			
			for(int j = i * i; j <= n2; j = j + i) prime[j] = true;
		}
		
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			int cnt = 0;
			for(int i = n + 1; i <= n * 2; ++i) {
				if(!prime[i]) ++cnt; 
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);

	}

}