import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
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

		int ans = 0;
		int max = A[N - 1];
		for (int i = N - 2; i >= 0; --i) {
			if (A[i] > max)
				max = A[i];
			else
				ans += (max - A[i]);
		}

		System.out.println(ans);

	}

}