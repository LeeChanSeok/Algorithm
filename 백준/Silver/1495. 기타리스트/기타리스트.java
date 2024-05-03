import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, s;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution());

	}

	private static int solution() {

		Queue<Integer> q = new LinkedList<>();
		q.offer(s);

		for (int i = 0; i < n; ++i) {
			int size = q.size();
			if (size == 0)
				return -1;

			boolean[] visited = new boolean[m + 1];
			while (size-- > 0) {
				int num = q.poll();

				int next = num + arr[i];
				if (next <= m && !visited[next]) {
					q.offer(next);
					visited[next] = true;
				}

				next = num - arr[i];
				if (next >= 0 && !visited[next]) {
					q.offer(next);
					visited[next] = true;
				}

			}

		}

		int max = -1;
		while (!q.isEmpty()) {
			max = Math.max(max, q.poll());
		}

		return max;
	}

}