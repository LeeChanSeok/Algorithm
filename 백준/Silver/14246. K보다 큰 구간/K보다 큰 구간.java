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
		
		int s = 0;
		int e = 0;
		long ans = 0;
		long sum = 0;
		
		while(e <= n) {
			if(sum > k) {
				ans += n - e + 1;
				sum -= num[s++];
			}else {
				sum += num[e++];
			}
		}
		
		System.out.println(ans);
	}

	private static void input() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) num[i] = Integer.parseInt(st.nextToken());
		
		k = Integer.parseInt(br.readLine());
	}

}