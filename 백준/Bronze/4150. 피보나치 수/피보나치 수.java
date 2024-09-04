import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N == 0)
			System.out.println(0);
		else if (N <= 2)
			System.out.println(1);
		else {
			BigInteger n1 = new BigInteger("1");
			BigInteger n2 = new BigInteger("1");

			for (int i = 3; i <= N; ++i) {
				BigInteger tmp = n1;
				n1 = n1.add(n2);
				n2 = tmp;
			}
			System.out.println(n1);
		}

	}

}