import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			for (int i = 0; i < N; ++i) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);

			long[] S = new long[N];
			Arrays.fill(S, Long.MAX_VALUE);

			for (int i = N - 1; i > 0; --i) {

				long sum = 0;
				for (int j = i, cnt = 0; j >= 0; --j, ++cnt) {
					sum = sum + (A[i] - A[j]);
					S[cnt] = Math.min(S[cnt], sum);
				}

			}

			long ans = 0;
			for (long s : S) {
				ans += s;
			}

			bw.write(ans + "\n");

		}

		bw.flush();

	}

}