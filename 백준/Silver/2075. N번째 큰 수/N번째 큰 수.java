import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			pq.offer(num);
		}

		for (int i = 1; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				int num = Integer.parseInt(st.nextToken());

				if (pq.peek() < num) {
					pq.poll();
					pq.offer(num);
				}

			}
		}

		System.out.println(pq.poll());

	}

}