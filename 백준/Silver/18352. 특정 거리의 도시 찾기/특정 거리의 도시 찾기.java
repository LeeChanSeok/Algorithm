import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<Integer>[] graph = new List[N + 1];
		for (int i = 1; i <= N; ++i)
			graph[i] = new LinkedList<>();

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
		}

		int[] dist = new int[N + 1];

		Queue<Integer> q = new LinkedList<>();
		q.offer(X);

		boolean[] visited = new boolean[N + 1];
		visited[X] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph[cur]) {
				if (visited[next])
					continue;

				q.offer(next);
				dist[next] = dist[cur] + 1;
				visited[next] = true;
			}
		}

		boolean isMatch = false;
		for (int i = 1; i <= N; ++i) {
			if (dist[i] == K) {
				isMatch = true;
				sb.append(i).append('\n');
			}
		}
		if (!isMatch)
			sb.append("-1");
		System.out.println(sb);

	}

}