import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer>[] graph;
	static int[] rank;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		rank = new int[N + 1];

		graph = new List[N + 1];
		for (int i = 1; i <= N; ++i)
			graph[i] = new LinkedList<Integer>();

		int a, b;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			++rank[b];
		}

		solution();

		bw.write(sb.toString());
		bw.flush();

		bw.close();
		br.close();

	}

	private static void solution() {

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; ++i) {
			if (rank[i] == 0) {
				q.offer(i);
			}
		}

		int cur;
		while (!q.isEmpty()) {

			cur = q.poll();
			sb.append(cur + " ");
			
			for(int next : graph[cur]) {
				--rank[next];
				if(rank[next] == 0) q.offer(next);
			}
		}

	}

}