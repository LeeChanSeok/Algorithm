import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int a, b;
		int cost;

		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}

	static int N, M, ans;
	static int[] parent;
	static List<Edge> network;

	public static void main(String[] args) throws Exception {

		input();
		pro();

	}

	private static void pro() throws Exception{

		ans = 0;
		
		for(Edge edge : network) {
						
			if(!findParent(edge.a, edge.b)) {
				ans += edge.cost;
				unionParent(edge.a, edge.b);
			}
		}
		
		System.out.println(ans);
		
	}

	private static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
		
	}

	private static boolean findParent(int a, int b) {

		if(getParent(a) == getParent(b)) return true;
		return false;
		
	}

	private static int getParent(int node) {

		if(node == parent[node]) return node;
		return parent[node] = getParent(parent[node]);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		network = new LinkedList<>();
		parent = new int[N+1];
		for(int i = 1; i <= N; ++i) parent[i] = i;
		
		for(int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			network.add(new Edge(a, b, c));
		}
		
		Collections.sort(network, (n1, n2) -> n1.cost - n2.cost);
	}

}