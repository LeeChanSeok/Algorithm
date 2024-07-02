import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[] cnt = new int[1001];
		while (T-- > 0) {
			Arrays.fill(cnt, 0);

			int N = Integer.parseInt(br.readLine());
			int maxN = 0;
			int maxCnt = 0;
			for (int i = 0; i < N; ++i) {
				int num = Integer.parseInt(br.readLine());
				++cnt[num];

				if (cnt[num] > maxCnt) {
					maxN = num;
					maxCnt = cnt[num];
				} else if (cnt[num] == maxCnt && num < maxN) {
					maxN = num;
				}
			}

			sb.append(maxN).append('\n');
		}

		System.out.println(sb);

	}

}