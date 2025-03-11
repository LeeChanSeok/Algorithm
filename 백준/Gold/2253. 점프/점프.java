import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int INF = (int)1e9;
		int MAXN = 10000;
		int MAXJ = 200;
		int[][] D = new int[MAXN+1][MAXJ + 1];
		for(int i = 0; i <= N; ++i) {
			Arrays.fill(D[i], INF);
		}
		
		boolean[] small = new boolean[MAXN + 1];		
		for(int i = 0; i < M; ++i) {
			small[Integer.parseInt(br.readLine())] = true;
		}
		
		D[1][0] = 0;
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 0; j <= MAXJ; ++j) {
				if(D[i][j] == INF) continue;
							
								
				for(int k = j - 1; k <= j + 1; ++k) {
					if(k <= 0 || i + k > N || small[i + k]) continue;
					D[i+k][k] = Math.min(D[i+k][k], D[i][j] + 1);
				}
			}
		}
		
		int ans = INF;
		for(int i = 0; i <= MAXJ; ++i) {
			ans = Math.min(ans, D[N][i]);
		}
		if(ans == INF) ans = -1;
		System.out.println(ans);
		

	}

}