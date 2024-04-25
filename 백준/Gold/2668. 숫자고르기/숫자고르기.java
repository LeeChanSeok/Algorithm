import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	static int cnt;
	static int[] arr;
	static boolean[] visited, res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];

		for (int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		cnt = 0;
		visited = new boolean[n + 1];
		res = new boolean[n + 1];
		for (int i = 1; i <= n; ++i) {
			if (visited[i])
				continue;

			bfs(i);
		}

		for (int i = 1; i <= n; ++i) {
			if (res[i]) {
				++cnt;
				sb.append(i).append('\n');
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

	private static void bfs(int start) {

		Set<Integer> set = new LinkedHashSet<>();

		int node = start;
		while (!set.contains(node)) {
			set.add(node);
			node = arr[node];
			visited[node] = true;
		}

		boolean isCycle = false;
		for (int num : set) {
			if (num == node)
				isCycle = true;
			res[num] = isCycle;

		}

	}

}