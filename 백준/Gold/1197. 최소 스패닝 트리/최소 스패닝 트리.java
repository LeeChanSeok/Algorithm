import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static int[] P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[E];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(from, to, weight);
		}
		P = new int[V+1];
		for(int i = 1; i <= V ; i++)
			P[i] = i;
		
		Arrays.sort(edges);
		
		int cnt = 0;
		int res = 0;
		
		for(Edge edge : edges) {
			if(union(edge.from, edge.to)) {
				res += edge.weight;
				if(++cnt == V-1) break;
			}
		}
		
		System.out.println(res);

	}

	private static boolean union(int a, int b) {

		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		P[bRoot] = aRoot;
		return true;
	}

	private static int find(int x) {
		if(x == P[x]) return x;
		return P[x] = find(P[x]);
	}

}