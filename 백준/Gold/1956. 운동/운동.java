import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int INF = 987654321;
	
	static int N, M;
	static int[][] A, D;

	public static void main(String[] args) throws Exception {

			input();
			pro();
	}

	private static void pro() {

		int ans = INF;
		for(int k = 1; k <= N; ++k) {
			for(int i = 1; i <= N; ++i) {
				for(int j = 1; j <= N; ++j) {
					if(D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= N; ++i) {
			ans = Math.min(ans, D[i][i]);
		}
		if(ans == INF) ans = -1;
		
		System.out.println(ans);
		
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		D = new int[N+1][N+1];
		for(int i = 1; i <= N; ++i) Arrays.fill(D[i], INF);
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			D[X][Y] = C;
		}
		
	}

}