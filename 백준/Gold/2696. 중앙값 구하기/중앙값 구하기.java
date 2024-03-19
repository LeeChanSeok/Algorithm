import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> maxQ;
		PriorityQueue<Integer> minQ;

		int t = Integer.parseInt(st.nextToken());
		while (t-- > 0) {
			int m = Integer.parseInt(br.readLine());

			minQ = new PriorityQueue<>(Comparator.reverseOrder());
			maxQ = new PriorityQueue<>();

			sb.append(m / 2 + 1).append('\n');

			int cnt = 0;
			for (int i = 0; i < m; ++i) {
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
				int num = Integer.parseInt(st.nextToken());

				if (minQ.size() == maxQ.size())
					maxQ.add(num);
				else
					minQ.add(num);

				if (!minQ.isEmpty() && !maxQ.isEmpty()) {
					if (minQ.peek() > maxQ.peek()) {
						int tmp = maxQ.poll();
						maxQ.add(minQ.poll());
						minQ.add(tmp);
					}
				}

				if (i % 2 == 0) {
					sb.append(maxQ.peek()).append(" ");
					++cnt;

					if (cnt % 10 == 0)
						sb.append('\n');
				}
			}

			sb.append('\n');

		}

		System.out.println(sb);

	}

}