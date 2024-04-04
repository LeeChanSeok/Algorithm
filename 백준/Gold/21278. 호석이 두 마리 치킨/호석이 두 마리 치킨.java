import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int INF = (int)1e9;
	static int n, m;
	static int[][] graph;
	static int[][] D;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		D = new int[n+1][n+1];
		for(int i = 1; i <= n; ++i) {
			Arrays.fill(D[i], INF);
			D[i][i] = 0;
		}
		
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			D[u][v] = D[v][u] = 1;
		}
		
		
		for (int k = 1; k <= n; ++k) {
			for(int i = 1; i <= n; ++i) {			
				for(int j = 1; j <= n; ++j) {
					D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
				}
			}
		}

		int[] ans = new int[] {0, 0, INF};
		for(int i = 1; i < n; ++i) {
			for(int j = i + 1; j <= n; ++j) {
				int sum = 0;
				for(int k = 1; k <= n; ++k) {
					sum += Math.min(D[i][k], D[j][k]);
				}
				
				if(ans[2] > sum) ans = new int[] {i, j, sum};
			}
		}
		
		System.out.println(ans[0] + " " + ans[1] + " " + ans[2] * 2);

	}

	private static void bfs() {

		for(int i = 1; i <= n; ++i) {
			
			Arrays.fill(D[i], INF);
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			
			D[i][i] = 0;
			
			int dist = 1;
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int next : graph[cur]) {
					if(D[i][next] != INF) continue;
					
					q.offer(next);
					D[i][next] = dist;
					
				}
				
				++dist;
			}
			
		}
		
	}

}