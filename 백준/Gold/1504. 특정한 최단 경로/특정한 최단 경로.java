import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;

	static int N, M;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N+1][N+1];
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = INF;
			}
		}
		
		int s, e, d;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			graph[s][e] = graph[e][s] = d;
		}
		
		int u, v;
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		int[] sDist, uDist, vDist;
		sDist = new int[N+1]; Arrays.fill(sDist, INF);
		uDist = new int[N+1]; Arrays.fill(uDist, INF);
		vDist = new int[N+1]; Arrays.fill(vDist, INF);
		
		bfs(sDist, 1);
		bfs(uDist, u);
		bfs(vDist, v);
		
		
		int answer = Math.min(sDist[u] + uDist[v] + vDist[N], 
				sDist[v] + vDist[u] + uDist[N]);
		
		if(answer >= INF || answer < 0) answer = -1;
		System.out.println(answer);
	}
	private static void bfs(int[] dist, int start) {
		
		PriorityQueue<int[]> q = new PriorityQueue<>((p1, p2)-> p1[1] - p2[1]);
		q.offer(new int[] {start, 0});
		
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int[] edge = q.poll();
			
			int node = edge[0];
			int d = edge[1];
			for(int i = 1; i <= N; ++i) {
				if(node == i || graph[node][i] == INF) continue;
				
				d = dist[node] + graph[node][i];
				if(dist[i] > d) {
					q.offer(new int[] {i, d});
					dist[i] = d;
				}
				
			}
		}
		
	}

}
