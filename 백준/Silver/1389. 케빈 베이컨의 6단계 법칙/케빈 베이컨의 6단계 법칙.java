import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		final int INF = Integer.MAX_VALUE;
		int[][] conn = new int[N+1][N+1];
		for(int i = 0; i <= N; ++i) Arrays.fill(conn[i], INF);
		int A, B;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			conn[A][B] = conn[B][A] = 1;
			
		}
		
		for(int k = 1; k <= N; ++k) {
			for(int i = 1; i <= N; ++i) {
				for(int j = 1; j <= N; ++j) {
					if(conn[i][k] == INF || conn[k][j] == INF || i == j) continue;
					conn[i][j] = Math.min(conn[i][j], conn[i][k] + conn[k][j]);
				}
					
			}
		}
		
		int idx = INF, dist = INF, cnt;
		for(int i = 1; i <= N; ++i) {
			
			cnt = 0;
			for(int j = 1; j <= N; ++j) {
				cnt += conn[i][j];
			}
			if(cnt < dist) {
				idx = i;
				dist = cnt;
			}
		}
		
		System.out.println(idx);
		
	}

}