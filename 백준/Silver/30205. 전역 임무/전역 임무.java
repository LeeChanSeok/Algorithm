import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long P = Long.parseLong(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; ++i) {
			int t = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1)
					++t;
				else {
					pq.offer(num);
				}
			}

			while (!pq.isEmpty()) {
				int num = pq.poll();
				if (num <= P)
					P += num;
				else {
					while (t > 0 && P < num) {
						P *= 2;
						--t;
					}

					if (P < num) {
						System.out.println(0);
						return;
					}
					P += num;

				}
			}

			while (t > 0) {
				P *= 2;
				--t;
			}
		}

		System.out.println(1);

	}

}