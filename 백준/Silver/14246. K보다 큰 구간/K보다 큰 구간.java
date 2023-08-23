import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[] num;
	static long[] subSum;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		for(int i = 1; i <= n; ++i) {
			subSum[i] = subSum[i-1] + num[i];
		}
		
		long ans = 0;
		
		for(int s = 1; s <= n; ++s) {
			
			if(subSum[n] - subSum[s-1] < k) break;
			for(int e = s; e <= n; ++e) {
				long sum = subSum[e] - subSum[s-1];
				if(sum > k) {
					ans += n - e + 1;
					break;
				}
			}
			
		}
		
		System.out.println(ans);
	}

	private static void input() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		subSum = new long[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) num[i] = Integer.parseInt(st.nextToken());
		
		k = Integer.parseInt(br.readLine());
	}

}