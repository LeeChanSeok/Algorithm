import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[] name, check;
	static int len;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		name = br.readLine().toCharArray();
		len = name.length;

		int N = Integer.parseInt(br.readLine());
		int idx = 0;
		for (; idx < N; ++idx) {
			check = br.readLine().toCharArray();
			if (len != check.length)
				continue;
			if (isGood()) {
				++idx;
				break;
			}
		}

		System.out.println(idx);
	}

	private static boolean isGood() {

		int diff = 0;
		for (int i = 0; i < len; ++i) {
			if (name[i] != check[i]) {
				++diff;
				if (diff == 2)
					return false;
			}
		}

		if (diff == 0)
			return false;
		return true;
	}

}