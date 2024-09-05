import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		if (N == 0)
			System.out.println(0);
		else {
			long a = 1;
			long k = 1;
			while (a < N) {
				a *= 2;
				++k;
			}

			System.out.println(k);
		}
	}

}