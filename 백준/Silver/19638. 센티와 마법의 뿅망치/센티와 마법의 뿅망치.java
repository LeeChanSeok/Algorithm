import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, H, T;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int res = solution();
		if (res == -1) {
			System.out.println("NO");
			System.out.println(pq.peek());
		} else {
			System.out.println("YES");
			System.out.println(res);
		}

	}

	private static int solution() {

		int cnt = 0;
		while (pq.peek() >= H && cnt < T) {
			if (pq.peek() == 1)
				return -1;

			pq.offer(pq.poll() / 2);
			++cnt;
		}

		if (pq.peek() < H)
			return cnt;

		return -1;
	}

}