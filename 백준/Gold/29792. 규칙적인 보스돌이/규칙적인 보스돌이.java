import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Boss {
		long p;
		int q;

		public Boss(long p, int q) {
			super();
			this.p = p;
			this.q = q;
		}

	}

	static int N, M, K;
	static long[] D;
	static Boss[] bosses;

	static int c, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		D = new long[N];
		for (int i = 0; i < N; ++i) {
			D[i] = Long.parseLong(br.readLine());
		}

		bosses = new Boss[K];
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			long p = Long.parseLong(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			bosses[i] = new Boss(p, q);

		}

		List<Integer> list = new ArrayList<>();
		for (c = 0; c < N; ++c) {
			max = 0;
			recursive(0, 900, 0);
			list.add(max);
		}

		Collections.sort(list, Collections.reverseOrder());
		long ans = 0;
		for (int i = 0; i < M; ++i) {
			ans += list.get(i);
		}
		System.out.println(ans);
	}

	private static void recursive(int b, int t, int v) {

		if (b == K) {
			max = Math.max(max, v);
			return;
		}

		Boss boss = bosses[b];

		// idx 번째 몬스터 잡기
		if (D[c] * t >= boss.p) {
			recursive(b + 1, t - (int) Math.ceil((double) boss.p / D[c]), v + boss.q);
		}

		// idx 번째 몬스터 잡지 않기
		recursive(b + 1, t, v);

	}

}