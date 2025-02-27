import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long lcm = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 2; ++i) {
			int num = Integer.parseInt(st.nextToken());
			lcm = lcm * num / gcd(lcm, num);
		}

		System.out.println(lcm);

	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}