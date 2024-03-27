import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int u, d;

		public Edge(int u, int d) {
			super();
			this.u = u;
			this.d = d;
		}

	}

	static int n, r;
	static List<Edge>[] tree;
	static boolean[] visited;
	static int h, l;
	static int giga;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		tree = new List[n + 1];
		for (int i = 1; i <= n; ++i) {
			tree[i] = new LinkedList<>();
		}

		for (int i = 0; i < n - 1; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			tree[a].add(new Edge(b, d));
			tree[b].add(new Edge(a, d));
		}

		h = l = 0;

		if (n != 1) {
			visited = new boolean[n + 1];

			calcHoleLength(r, 0);
			calcLeafLength(giga, 0);
		}

		System.out.println(h + " " + l);

	}

	private static void calcLeafLength(int node, int total) {
		visited[node] = true;

		if (tree[node].size() == 1) {
			l = Math.max(l, total);
			return;
		}

		for (Edge next : tree[node]) {
			if (visited[next.u])
				continue;

			calcLeafLength(next.u, total + next.d);
		}

	}

	private static void calcHoleLength(int node, int total) {

		visited[node] = true;

		if (tree[node].size() > 2 || (tree[node].size() == 1 && node != r) || (tree[node].size() == 2 && node == r)) {
			h = total;
			giga = node;
			return;
		}

		for (Edge next : tree[node]) {
			if (visited[next.u])
				continue;

			calcHoleLength(next.u, total + next.d);
		}

	}

}