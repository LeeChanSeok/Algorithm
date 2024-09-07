import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int MAX_C = 1000;
		int[] arr = new int[MAX_C + 1];
		Set<Double> angle = new HashSet<>();
		angle.add(0.);
		angle.add(1.);

		arr[1] = 3;
		for (int k = 2; k <= MAX_C; ++k) {

			arr[k] = arr[k - 1];
			for (int x = 1; x <= k; ++x) {
				double a = (double) k / x;
				if (!angle.contains(a)) {
					angle.add(a);
					++arr[k];
				}
			}

			for (int y = k - 1; y > 0; --y) {
				double a = (double) y / k;
				if (!angle.contains(a)) {
					angle.add(a);
					++arr[k];
				}
			}

		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(arr[N]);
		}
	}

}