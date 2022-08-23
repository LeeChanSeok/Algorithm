import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int w, to;

		public Edge(int w, int to) {
			super();
			this.w = w;
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static int V, E;
	static List<Edge>[] graph;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new List[V + 1];
			visit = new boolean[V + 1];

			for (int i = 0; i < V + 1; i++)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				graph[from].add(new Edge(weight, to));
				graph[to].add(new Edge(weight, from));

			}

			long res = 0;
			int cnt = 1;
			int vertex = 1;
			visit[vertex] = true;
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (Edge e : graph[vertex])
				pq.add(e);

			while (!pq.isEmpty()) {

				Edge cur = pq.poll();
				if (!visit[cur.to]) {
					visit[cur.to] = true;
					res += cur.w;
					if(++cnt == V) break;
					for (Edge e : graph[cur.to])
						pq.add(e);
				}

			}

			sb.append("#" + tc + " " + res + "\n");
		} // test-case 종료
		bw.write(sb.toString());
		bw.close();

	}

}