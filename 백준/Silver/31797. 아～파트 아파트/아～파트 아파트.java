import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Hand {
		int h, idx;

		public Hand(int h, int idx) {
			super();
			this.h = h;
			this.idx = idx;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int max = 0;
		PriorityQueue<Hand> pq = new PriorityQueue<>((p1, p2) -> p1.h - p2.h);
		for (int i = 1; i <= m; ++i) {
			st = new StringTokenizer(br.readLine());

			int H1 = Integer.parseInt(st.nextToken());
			int H2 = Integer.parseInt(st.nextToken());

			max = Math.max(max, H1);
			max = Math.max(max, H2);

			pq.offer(new Hand(H1, i));
			pq.offer(new Hand(H2, i));
		}

		for (int i = 0; i < n; ++i) {

			Hand hand = pq.poll();
			pq.offer(new Hand(++max, hand.idx));
		}

		while (pq.size() != 1)
			pq.poll();

		System.out.println(pq.peek().idx);

	}

}