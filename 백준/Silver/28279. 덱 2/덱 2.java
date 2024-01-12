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
		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				q.addFirst(b);
			} else if (a == 2) {
				int b = Integer.parseInt(st.nextToken());
				q.addLast(b);
			} else if (a == 3) {
				if (q.isEmpty())
					sb.append("-1\n");
				else
					sb.append(q.pollFirst()).append('\n');
			} else if (a == 4) {
				if (q.isEmpty())
					sb.append("-1\n");
				else
					sb.append(q.pollLast()).append('\n');
			} else if (a == 5) {
				sb.append(q.size()).append('\n');
			} else if (a == 6) {
				if (q.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (a == 7) {
				if (q.isEmpty())
					sb.append("-1\n");
				else
					sb.append(q.peekFirst()).append('\n');
			} else if (a == 8) {
				if (q.isEmpty())
					sb.append("-1\n");
				else
					sb.append(q.peekLast()).append('\n');
			}
		}
		
		System.out.println(sb);

	}

}