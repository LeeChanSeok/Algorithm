import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			br.readLine();

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] S = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(S);

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; ++i) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(B);

			int i = 0, j = 0;
			while (i != N && j != M) {
				if (B[j] <= S[i])
					++j;
				else
					++i;
			}

			if (i == N)
				System.out.println('B');
			else
				System.out.println('S');

		}

	}

}