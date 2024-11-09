import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();
		int len = arr.length;
		boolean isCap = false;
		int cnt = 0;

		for (int i = 0; i < len - 1; ++i) {
			if (isCap && !isCapitals(arr[i])) {
				if (!isCapitals(arr[i + 1])) {
					isCap = false;
				}
				++cnt;
			} else if (!isCap && isCapitals(arr[i])) {
				if (isCapitals(arr[i + 1])) {
					isCap = true;
				}
				++cnt;
			}
		}

		if ((isCap && !isCapitals(arr[len - 1])) || (!isCap && isCapitals(arr[len - 1])))
			++cnt;

		System.out.println(len + cnt);
	}

	private static boolean isCapitals(char c) {
		if (c >= 'A' && c <= 'Z')
			return true;
		return false;
	}

}