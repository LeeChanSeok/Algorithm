import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	final static int alphaCnt = (int) ('Z' - 'A') + 1;

	static Map<Integer, char[]> num2charArr;
	static String S;
	static int len;
	static int[] alphaArr;
	static int[] numArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		num2charArr = new HashMap<>();
		num2charArr.put(0, new char[] { 'Z', 'E', 'R', 'O' });
		num2charArr.put(1, new char[] { 'O', 'N', 'E' });
		num2charArr.put(2, new char[] { 'T', 'W', 'O' });
		num2charArr.put(3, new char[] { 'T', 'H', 'E', 'R', 'E' });
		num2charArr.put(4, new char[] { 'F', 'O', 'U', 'R' });
		num2charArr.put(5, new char[] { 'F', 'I', 'V', 'E' });
		num2charArr.put(6, new char[] { 'S', 'I', 'X' });
		num2charArr.put(7, new char[] { 'S', 'E', 'V', 'E', 'N' });
		num2charArr.put(8, new char[] { 'E', 'I', 'G', 'H', 'T' });
		num2charArr.put(9, new char[] { 'N', 'I', 'N', 'E' });

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			bw.write(String.format("Case #%d: ", tc));

			S = br.readLine();
			len = S.length();
			alphaArr = new int[alphaCnt];
			for (int i = 0; i < len; ++i) {
				++alphaArr[S.charAt(i) - 'A'];
			}

			numArr = new int[10];
			recursive(len, 0);

			for (int i = 0; i < 10; ++i) {
				for (int j = 0; j < numArr[i]; ++j) {
					bw.write(String.valueOf(i));
				}
			}

			bw.write("\n");
		}

		bw.flush();

	}

	private static boolean recursive(int wlen, int idx) {

		if (wlen == 0) {
			return true;
		}

		for (int i = idx; i < 10; ++i) {
			char[] arr = num2charArr.get(i);

			if (isExist(arr)) {
				++numArr[i];
				if (recursive(wlen - arr.length, i))
					return true;
				--numArr[i];
			}
			recover(arr);
		}

		return false;

	}

	private static boolean isExist(char[] arr) {

		boolean isTrue = true;
		for (int i = 0; i < arr.length; ++i) {

			--alphaArr[arr[i] - 'A'];
			if (alphaArr[arr[i] - 'A'] < 0)
				isTrue = false;
		}
		return isTrue;
	}

	private static void recover(char[] arr) {

		for (int i = 0; i < arr.length; ++i) {
			++alphaArr[arr[i] - 'A'];
		}
	}

}