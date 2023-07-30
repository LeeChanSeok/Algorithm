import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

	static BigInteger n;

	public static void main(String[] args) throws Exception {

		input();
		pro();
	}

	private static void pro() {

		BigInteger l = BigInteger.valueOf(1);
		BigInteger r = n;
		BigInteger mid = new BigInteger("0");
		
		while (l.compareTo(r) <= 0) {
			mid = (l.add(r)).divide(new BigInteger("2"));

			BigInteger target = mid.multiply(mid);
			int result = target.compareTo(n);

			if (result == 0) {
				break;
			} else if (result == 1) {
				r = mid.subtract(new BigInteger("1"));
			} else
				l = mid.add(new BigInteger("1"));

		}

		System.out.println(mid.toString());
	}

	private static void input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = new BigInteger(br.readLine());

	}

}