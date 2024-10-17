import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		char[] arr = br.readLine().toCharArray();
		long cnt = 0;
		for (int i = 0; i < N; ++i) {
			if (arr[i] == '0') {
				ans += cnt * (cnt + 1) / 2;
				cnt = 0;
			} else {
				++cnt;
			}
		}
		ans += cnt * (cnt + 1) / 2;
		System.out.println(ans);

	}

}