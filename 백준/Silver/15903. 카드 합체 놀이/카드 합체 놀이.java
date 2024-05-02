import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			pq.offer(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < m; ++i) {
			long p = pq.poll();
			long q = pq.poll();

			pq.offer(p + q);
			pq.offer(p + q);
		}

		long sum = 0;
		for (long num : pq) {
			sum += num;
		}

		System.out.println(sum);

	}

}