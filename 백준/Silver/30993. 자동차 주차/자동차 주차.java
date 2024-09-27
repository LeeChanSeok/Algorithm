import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int res1 = comb(N, A);
		int res2 = comb(N - A, B);
		int res3 = comb(N - A - B, C);

		System.out.println(res1 * res2 * res3);

	}

	public static int comb(int n, int r) {
		if (r == 0 || n == r)
			return 1;
		else
			return comb(n - 1, r - 1) + comb(n - 1, r);
	}

}