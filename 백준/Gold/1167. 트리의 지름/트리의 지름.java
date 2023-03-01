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
	
	static int V;
	static long max = 0;
	static boolean[] visit;
	static List[] graph;
	static Edge endNode;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		graph = new List[V+1];
		int v, n, d;
		for(int i = 0; i < V; ++i) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			graph[v] = new LinkedList<Edge>();
			
			while((n = Integer.parseInt(st.nextToken())) != -1) {
				d = Integer.parseInt(st.nextToken());
				graph[v].add(new Edge(n, d));
			}
		}
	
		endNode = new Edge(0, 0);
		visit = new boolean[V+1];
		dfs(1, 0);
		
		int node = endNode.node;
		endNode = new Edge(node, 0);
		visit = new boolean[V+1];
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