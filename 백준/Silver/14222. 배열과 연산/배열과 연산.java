import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}

		if (solution())
			System.out.println('1');
		else
			System.out.println('0');
	}

	private static boolean solution() {

		int target = 1;
		while (!pq.isEmpty()) {
			if (pq.peek() == target) {
				pq.poll();
				++target;
			} else if (pq.peek() < target) {
				pq.offer(pq.poll() + K);
			} else
				return false;
		}

		return true;
	}

}