import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] sumArr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			sumArr[i] += sumArr[i - 1] + Integer.parseInt(st.nextToken());
		}

		int[] ans = new int[] { 0, 0 };
		for (int i = X; i <= N; ++i) {
			int cnt = sumArr[i] - sumArr[i - X];
			if (cnt == ans[0])
				++ans[1];
			else if (cnt > ans[0]) {
				ans = new int[] { cnt, 1 };
			}
		}

		if (ans[0] == 0)
			System.out.println("SAD");
		else {
			System.out.println(ans[0]);
			System.out.println(ans[1]);
		}

	}

}