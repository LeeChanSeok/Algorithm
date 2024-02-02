import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Deque<int[]> q = new ArrayDeque();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			q.add(new int[] { i, num });
		}

		int[] b = q.pollFirst();
		sb.append("1 ");
		int move = b[1];

		while (!q.isEmpty()) {
			if (move > 0) {
				for (int i = 1; i < move; i++) {
					q.add(q.poll());
				}

				int[] nxt = q.poll();
				move = nxt[1];
				sb.append(nxt[0] + " ");
			}
			else {
				for (int i = 1; i < -move; i++) {
					q.addFirst(q.pollLast());
				}

				int[] nxt = q.pollLast();
				move = nxt[1];
				sb.append(nxt[0] + " ");
			}
		}
		System.out.println(sb);
	}

}