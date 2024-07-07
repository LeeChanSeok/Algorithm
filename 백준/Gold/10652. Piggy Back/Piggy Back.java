import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static long B, E, P;
	static int N, M;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		B = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for (int i = 1; i <= N; ++i) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		solution();

	}

	private static void solution() {

		int[] dist_B = new int[N + 1];
		int[] dist_E = new int[N + 1];
		int[] dist_N = new int[N + 1];

		dijkstra(dist_B, 1);
		dijkstra(dist_E, 2);
		dijkstra(dist_N, N);

		long min = Long.MAX_VALUE;
		for (int i = 1; i <= N; ++i) {
			long energy = (dist_B[i] * B + dist_E[i] * E + dist_N[i] * P);
			min = Math.min(min, energy);
		}

		System.out.println(min);

	}

	private static void dijkstra(int[] dist, int s) {

		Arrays.fill(dist, -1);
		dist[s] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.offer(s);

		int move = 1;
		while (!q.isEmpty()) {
			int qSize = q.size();

			while (qSize-- > 0) {
				int cur = q.poll();

				for (int next : graph[cur]) {
					if (dist[next] != -1)
						continue;

					dist[next] = move;
					q.offer(next);
				}
			}

			++move;
		}

	}

}