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
	static List<Integer>[] graph;
	static int[][] D;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new List[n+1];
		for(int i = 1; i <= n; ++i) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		D = new int[n+1][n+1];
		
		bfs();
		
		int[] ans = new int[3];
		ans[2] = Integer.MAX_VALUE;
		
		for(int i = 1; i < n; ++i) {			
			for(int j = i + 1; j <= n; ++j) {
				int res = 0;
				for(int k = 1; k <= n; ++k) {
					res += Math.min(D[i][k], D[j][k]);
				}
				
				if(res < ans[2]) ans = new int[] {i, j, res};
			}
		}
		
		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]*2);

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