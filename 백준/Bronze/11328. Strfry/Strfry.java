import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr1, arr2;
	static int range = (int) ('z' - 'a' + 1);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		arr1 = new int[range];
		arr2 = new int[range];

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			String str1 = st.nextToken();
			String str2 = st.nextToken();

			if (stfry(str1, str2))
				sb.append("Possible\n");
			else
				sb.append("Impossible\n");

		}

		System.out.println(sb);
	}

	private static boolean stfry(String str1, String str2) {

		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 != len2)
			return false;

		Arrays.fill(arr1, 0);
		Arrays.fill(arr2, 0);

		for (int i = 0; i < len1; ++i) {
			++arr1[(int)('z' - str1.charAt(i))];
			++arr2[(int)('z' - str2.charAt(i))];
		}

		for (int i = 0; i < range; ++i) {
			if (arr1[i] != arr2[i])
				return false;
		}

		return true;
	}

}