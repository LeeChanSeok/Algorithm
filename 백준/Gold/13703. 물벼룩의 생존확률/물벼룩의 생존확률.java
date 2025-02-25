import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[][] D = new long[64][64];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		recursive(k, n);
		long ans = (2l << (n - 1)) - D[k][n];
		System.out.println(ans);
	}

	private static long recursive(int k, int n) {

		if (D[k][n] != 0)
			return D[k][n];
		if (k > n)
			return D[k][n] = 0;
		if (k == 0)
			return D[k][n] = (2l << (n - 1));
		if (n == k)
			return D[k][n] = 1;
		return D[k][n] = recursive(k - 1, n - 1) + recursive(k + 1, n - 1);

	}

}