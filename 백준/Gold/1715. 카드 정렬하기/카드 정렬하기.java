import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= n; ++i) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int res = 0;
		while (pq.size() != 1) {
			int n1 = pq.poll();
			int n2 = pq.poll();
			int sum = n1 + n2;

			res += sum;
			pq.offer(sum);

		}

		System.out.println(res);
	}

}