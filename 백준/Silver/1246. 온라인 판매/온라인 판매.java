import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		P = new int[M];
		for (int i = 0; i < M; ++i) {
			P[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(P);

		long income = 0;
		long price = 0;

		for (int i = 0; i < M; ++i) {
			long v = P[i] * Math.min(M - i, N);

			if (v > income) {
				income = v;
				price = P[i];
			}
		}

		System.out.println(price + " " + income);

	}

}