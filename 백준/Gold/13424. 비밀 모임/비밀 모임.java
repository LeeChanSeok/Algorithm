import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

	}

	static final int maxN = 100;
	static final int maxC = 1000;
	static int[][] graph = new int[maxN + 1][maxN + 1];
	static int N, M;

	static int[] D = new int[maxN + 1];
	static int[] dist = new int[maxN + 1];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= maxN; ++i) {
				Arrays.fill(graph[i], (int) 1e9);
			}
			Arrays.fill(D, 0);

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				graph[a][b] = graph[b][a] = c;
			}

			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; ++i) {
				int node = Integer.parseInt(st.nextToken());
				dijkstra(node);

				for (int j = 1; j <= N; ++j) {
					D[j] += dist[j];
				}
			}

			int res = 0;
			int min = Integer.MAX_VALUE;
			for(int i = 1; i <= N; ++i) {
				if(D[i] < min) {
					min = D[i];
					res = i;
				}
			}
			
			sb.append(res).append('\n');
		}
		System.out.println(sb);

	}

	private static void dijkstra(int node) {
		Arrays.fill(dist, (int) 1e9);

		PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.cost - v2.cost);
		pq.offer(new Node(node, 0));

		dist[node] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.idx] < cur.cost)
				continue;

			for (int i = 1; i <= N; ++i) {

				if (graph[cur.idx][i] == (int) 1e9)
					continue;

				int nd = cur.cost + graph[cur.idx][i];
				if (dist[i] > nd) {
					dist[i] = nd;
					pq.offer(new Node(i, nd));
				}

			}
		}

	}

}