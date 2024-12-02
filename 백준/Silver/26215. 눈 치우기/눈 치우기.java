import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			pq.offer(num);
		}

		int time = 0;
		while (!pq.isEmpty() && time < 1440) {
			if (pq.size() == 1) {
				int num1 = pq.poll() - 1;
				if (num1 != 0)
					pq.offer(num1);
			} else {
				int num1 = pq.poll() - 1;
				int num2 = pq.poll() - 1;
				if (num1 != 0)
					pq.offer(num1);
				if (num2 != 0)
					pq.offer(num2);
			}

			++time;
		}

		if (pq.isEmpty())
			System.out.println(time);
		else
			System.out.println(-1);

	}

}