import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] ryan;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ryan = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) ryan[i] = Integer.parseInt(st.nextToken());
		
		solution();

	}

	private static void solution() {

		int R = 0, cnt = 0;
		int min = Integer.MAX_VALUE;
		for(int L = 1; L <= N; ++L) {
			if(ryan[L-1] == 1) --cnt;
			
			while(R < N && cnt < K) {
				if(ryan[++R] == 1) ++cnt;
			}
			
			if(cnt >= K)
				min = Math.min(min, R - L + 1);
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}

}