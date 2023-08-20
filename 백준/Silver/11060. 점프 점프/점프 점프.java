import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int INF = Integer.MAX_VALUE;
	static int n;
	static int[] arr;
	static int[] D;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		D[1] = 0;
	
		for(int i = 1; i < n; ++i) {
			if(D[i] == INF) continue;
			
			int step = arr[i];
			for(int j = 1; j <= step; ++j) {
				int next = i + j;
				if(next > n) break;
				
				D[next] = Math.min(D[next], D[i] + 1);
				
			}
		}
		
		int ans = D[n];
		if(ans == INF) ans = -1;
		System.out.println(ans);
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		D = new int[n+1];
		Arrays.fill(D, INF);
	}

}