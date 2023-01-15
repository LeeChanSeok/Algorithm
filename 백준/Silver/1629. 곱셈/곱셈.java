import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		long res = multifly(A, B, C);
		System.out.println(res);
	}

	private static long multifly(long a, long b, long c) {

		if (b == 1)	return a % c;

		long temp = multifly(a, b / 2, c);
		temp = temp * temp % c;
				
		if ((b & 1) == 1) return temp * a % c;
		return temp;

	}

}