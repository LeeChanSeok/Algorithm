import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class Edge{
		int node;
		long dist;

		public Edge(int node, long dist) {
			super();
			this.node = node;
			this.dist = dist;
		}
		
	}
	
	static int N;
	static long max = 0;
	static boolean[] visit;
	static List[] graph;
	static Edge endNode;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new List[N+1];
		int p, c, d;
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<Edge>();
		for(int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			graph[p].add(new Edge(c, d));
			graph[c].add(new Edge(p, d));
		}
	
		endNode = new Edge(1, 0);
		visit = new boolean[N+1];
		dfs(1, 0);
		
		int node = endNode.node;
		endNode = new Edge(node, 0);
		visit = new boolean[N+1];
		dfs(node, 0); 
		
		System.out.println(endNode.dist);
	}

	
	private static void dfs(int v, long total) {
		
		visit[v] = true;
		int node;
		List<Edge> edgelist = graph[v];
		for(Edge e : edgelist) {
			node = e.node;
			if(visit[node])continue;
			
			dfs(node, total + e.dist);
		}
		
		if(total > endNode.dist) {
			endNode = new Edge(v, total);
		}
		
	}

}