import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long l = 0, r = n;

		long res = 0;
		while (l <= r) {
			long mid = (l + r) / 2;
			
			if (Math.pow(mid, 2) >= n) {
				res = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		System.out.println(res);

	}

}