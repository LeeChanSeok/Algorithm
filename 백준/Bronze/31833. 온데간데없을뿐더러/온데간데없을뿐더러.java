import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		String A = "", B = "";
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A += st.nextToken();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			B += st.nextToken();
		}

		BigInteger num1 = new BigInteger(A);
		BigInteger num2 = new BigInteger(B);

		if (num1.compareTo(num2) < 0)
			System.out.println(A);
		else
			System.out.println(B);
	}

}