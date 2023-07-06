import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static class Edge{
		int node, dist;

		public Edge(int node, int dist) {
			super();
			this.node = node;
			this.dist = dist;
		}
		
	}
	
	static int N, M, start;
	static List<Edge>[] graph;
	static int[][] ab;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		input();
		
		sb = new StringBuilder();
		visited = new boolean[N + 1];
		
		while(M-- > 0) {
			pro();			
		}
		System.out.println(sb.toString());
		
	}

	private static void pro() throws IOException {
		
		Arrays.fill(visited, false);
		
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		int d = bfs(from, to);
		
		sb.append(d).append("\n");
		
	}

	private static int bfs(int from, int to) {

		Queue<Edge> q = new LinkedList<>();
		q.offer(new Edge(from, 0));
		
		visited[from] = true;
		
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			
			if(cur.node == to) return cur.dist;
			
			for(Edge next : graph[cur.node]) {
				if(visited[next.node]) continue;
				
				visited[next.node] = true;
				q.offer(new Edge(next.node, cur.dist + next.dist));
			}
		}
		
		return -1;
		
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		for(int i = 1; i <= N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, d));
			graph[b].add(new Edge(a, d));
		}
		
	}
	
}