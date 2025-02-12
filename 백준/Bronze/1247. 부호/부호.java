import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; ++i) {
			int N = Integer.parseInt(br.readLine());

			BigInteger num = BigInteger.ZERO;
			for (int j = 0; j < N; ++j) {
				num = num.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
			}

			String ans = "";
			if (num.compareTo(BigInteger.ZERO) == 0)
				ans = "0";
			else if (num.compareTo(BigInteger.ZERO) > 0)
				ans = "+";
			else
				ans = "-";

			System.out.println(ans);
		}

	}

}