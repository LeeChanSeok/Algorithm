import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r;
	static List<Integer>[] graph;
	static int[] visited;
	static long[] depth;
	static int step;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		visited = new int[n + 1];
		depth = new long[n + 1];

		graph = new List[n + 1];
		for (int i = 1; i <= n; ++i) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= n; ++i) {
			Collections.sort(graph[i]);
		}

		step = 1;
		bfs(r);

		long total = 0;
		for (int i = 1; i <= n; i++) {
			total += visited[i] * depth[i];
		}
		System.out.print(total);
	}

	private static void bfs(int r) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(r);
		visited[r] = step++;
		depth[r] = 0;

		int dp = 1;
		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				int cur = q.poll();

				for (int next : graph[cur]) {
					if (visited[next] != 0)
						continue;
					visited[next] = step++;
					depth[next] = dp;
					q.offer(next);
				}

			}
			++dp;
		}

	}

}