import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
			return this.d - o.d;
		}

	}

	static List<Edge>[] graph;
	static int[] dist;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new List[n + 1];
		for (int i = 1; i <= n; ++i) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[u].add(new Edge(v, c));
			graph[v].add(new Edge(u, c));
		}

		int ans = prime();
		System.out.println(ans);

	}

	private static int prime() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));

		boolean[] visited = new boolean[n + 1];
		int dist = 0;
		int cnt = 0;

		int max = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (visited[cur.u])
				continue;
			visited[cur.u] = true;
			max = Math.max(max, cur.d);
			dist += cur.d;
			
			for (Edge next : graph[cur.u]) {
				if(visited[next.u]) continue;
				pq.offer(next);
			}
		}
		
		return dist - max;

	}

}