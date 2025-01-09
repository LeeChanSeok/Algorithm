import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		long[] ans = new long[2];
		int l = 0, r = N - 1;
		int idx = 0;
		while (l <= r) {
			if (idx % 2 == 0)
				ans[idx] += A[r--];
			else
				ans[idx] += A[l++];
			idx = (idx + 1) % 2;
		}

		System.out.println(ans[1] + " " + ans[0]);

	}

}