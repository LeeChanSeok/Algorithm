import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, R, Q;
	static List<Integer>[] graph;
	static int[] D;

	public static void main(String[] args) throws IOException {

		input();
		pro();

	}

	private static void pro() throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		dfs(R, -1);

		for (int i = 0; i < Q; ++i) {
			int target = Integer.parseInt(br.readLine());
			sb.append(D[target]).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void dfs(int node, int prev) {

		for (int next : graph[node]) {
			if (next == prev) continue;

			dfs(next, node);
			D[node] += D[next];
		}

	}

	private static void input() throws IOException {

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		graph = new LinkedList[N + 1];
		for (int i = 1; i <= N; ++i)
			graph[i] = new LinkedList<>();

		for (int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);

		}

		D = new int[N + 1];
		Arrays.fill(D, 1);

	}

}