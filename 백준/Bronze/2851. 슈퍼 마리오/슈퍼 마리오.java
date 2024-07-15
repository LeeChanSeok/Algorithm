import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 10;

		int ans = 0;
		int min = 100;
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			sum += Integer.parseInt(br.readLine());

			int diff = (int) Math.abs(sum - 100);
			if (min >= diff) {
				ans = sum;
				min = diff;
			}

		}

		System.out.println(ans);
	}

}