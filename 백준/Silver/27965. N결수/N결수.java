import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		long num = 0;
		int cnt = 1;
		int pow = 10;
		for (int i = 1; i <= N; ++i) {
			if (cnt == pow) {
				pow *= 10;
			}
			num *= pow;
			num += i;
			num %= K;
			++cnt;
		}

		System.out.println(num);

	}

}