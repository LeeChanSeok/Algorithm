import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String S;
	static int sLen, tLen;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		String T = br.readLine();

		sLen = S.length();
		tLen = T.length();

		int ans = 0;
		if (recursive(new StringBuilder(T), tLen))
			ans = 1;

		System.out.println(ans);

	}

	private static boolean recursive(StringBuilder sb, int len) {

		if (len == sLen) {
			if (sb.toString().compareTo(S) == 0)
				return true;

			return false;
		}

		if (sb.charAt(len - 1) == 'A') {
			StringBuilder temp = new StringBuilder(sb);
			if (recursive(temp.deleteCharAt(len - 1), len - 1))
				return true;
		}
		if (sb.charAt(0) == 'B') {
			StringBuilder temp = (new StringBuilder(sb)).reverse();
			if (recursive(temp.deleteCharAt(len - 1), len - 1))
				return true;
		}

		return false;

	}

}