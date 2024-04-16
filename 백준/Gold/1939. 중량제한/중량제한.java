import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int u, d;

		public Edge(int u, int d) {
			super();
			this.u = u;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {

			return o.d - this.d;
		}

	}

	static int n, m;
	static int c;
	static int p, q;
	static List<Edge>[] graph;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new List[n + 1];
		for (int i = 1; i <= n; ++i) {
			graph[i] = new LinkedList<>();
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, c));
			graph[v].add(new Edge(u, c));

			min = Math.min(min, c);
			max = Math.max(max, c);
		}

		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		binarySearch(min, max);
	}

	private static void binarySearch(int left, int right) {

		int ans = left;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (bfs(mid)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(ans);
	}

	private static boolean bfs(int c) {

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.offer(new Edge(p, c));

		boolean[] visited = new boolean[n + 1];
		visited[p] = true;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.u == q)
				return true;

			for (Edge next : graph[cur.u]) {
				if (visited[next.u])
					continue;
				if (next.d < c)
					continue;

				visited[next.u] = true;
				pq.offer(new Edge(next.u, (int) Math.min(next.d, cur.d)));
			}
		}

		return false;
	}

}