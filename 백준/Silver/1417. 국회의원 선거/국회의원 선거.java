import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int score = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 1; i < N; ++i) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int ans = 0;
		while (!pq.isEmpty() && score <= pq.peek()) {
			pq.offer(pq.poll() - 1);
			++score;
			++ans;
		}

		System.out.println(ans);

	}

}