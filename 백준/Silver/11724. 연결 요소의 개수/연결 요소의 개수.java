import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[][] graph = new boolean[N+1][N+1];
		int u, v;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			graph[u][v] = graph[v][u] = true;
		}
		
		int connect = 0;
		boolean[] isConnected = new boolean[N+1];
		for(int i = 1; i <= N; ++i) {
			if(isConnected[i]) continue;
			++connect;
			
			bfs(N, i, graph, isConnected);
		}
		
		System.out.println(connect);
	}

	private static void bfs(int N, int n, boolean[][] graph, boolean[] isConnected) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int i = 1; i <= N; ++i) {
				if(graph[cur][i] && !isConnected[i]) {
					isConnected[i] = true;
					q.add(i);
				}
			}
			
		}
		
	}

}