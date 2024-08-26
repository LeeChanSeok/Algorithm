import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static String str;
	static int N;
	static int[] dp;
	static Map<Character, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int MOD = 1000000007;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				pq.offer(Long.parseLong(st.nextToken()));
			}

			long ans = 1;
			while (pq.size() != 1) {
				long num1 = pq.poll();
				long num2 = pq.poll();

				long res = num1 * num2;

				ans *= res % MOD;
				ans %= MOD;

				pq.offer(res);
			}

			System.out.println(ans);
		}

	}

}