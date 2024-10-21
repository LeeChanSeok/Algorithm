import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int zeroCnt = 0, oneCnt = 0;

		String str = br.readLine();
		int len = str.length();
		for (int i = 0; i < len; ++i) {
			if (str.charAt(i) == '0')
				++zeroCnt;
			else
				++oneCnt;
		}

		int zero = 0, one = 0;

		for (int i = 0; i < len; ++i) {
			char c = str.charAt(i);
			if (c == '0') {
				if (zero < zeroCnt / 2) {
					sb.append('0');
					++zero;
				}
			} else {
				if (one >= oneCnt / 2) {
					sb.append('1');
				}
				++one;
			}

		}
		
		System.out.println(sb);

	}

}