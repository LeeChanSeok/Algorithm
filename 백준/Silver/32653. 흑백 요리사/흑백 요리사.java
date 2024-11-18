import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res = lcm(res, arr[i]);
		}

		int idx = 2;
		long ans = res;
		while (!isEven(arr, ans)) {
			ans = res * (idx++);
		}

		System.out.println(ans);

	}

	private static boolean isEven(int[] arr, long res) {
		for (int i = 0; i < arr.length; i++) {
			if ((res / arr[i]) % 2 != 0)
				return false;

		}
		return true;
	}

	public static long gcd(long a, long b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}

	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

}