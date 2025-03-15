import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Double N = Double.parseDouble(br.readLine());

		double ans = 0;
		for (int i = 1; i <= N; ++i) {
			ans += (N / i);
		}
		System.out.printf("%.19f", ans);

	}

}