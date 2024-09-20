import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int ans = 1;
		int k = 1;
		for (int i = 1; i <= N; ++i) {
			ans += k;
			if (i % 3 != 0)
				++k;

		}

		System.out.println(ans);

	}

}