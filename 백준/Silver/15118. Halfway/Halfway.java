import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		long total = N * (N - 1) / 2;

		long target = total / 2;
		if (total % 2 != 0)
			++target;

		long ans = 0;
		long sum = 0;
		for (long i = 1; i <= N; ++i) {
			sum += N - i;
			if (sum >= target) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);

	}

}