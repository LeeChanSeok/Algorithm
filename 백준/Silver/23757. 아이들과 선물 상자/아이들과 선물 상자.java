import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static PriorityQueue<Integer> pq;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>((a, b) -> b - a);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}

		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		if (solution())
			ans = 1;
		System.out.println(ans);

	}

	private static boolean solution() {

		for (int i = 0; i < M; ++i) {
			int diff = pq.poll() - arr[i];
			if (diff < 0)
				return false;
			else if (diff > 0)
				pq.offer(diff);
		}

		return true;
	}

}