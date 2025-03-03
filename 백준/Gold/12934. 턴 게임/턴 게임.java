import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long A, B;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		long C = (A + B);
		long n = 1;
		while (true) {
			long X = n * (n + 1) / 2;
			if (C == X)
				break;
			else if (X > C) {
				n = -1;
				break;
			}
			++n;
		}

		ans = -1;
		if (n != -1) {
			int cnt = 0;
			while (A > 0) {
				A -= (n--);
				++cnt;
			}
			ans = cnt;
		}
		System.out.println(ans);
	}

}