import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		String[] A = new String[N];
		for (int i = 0; i < N; ++i) {
			A[i] = br.readLine();
		}

		int[] price = new int[7];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; ++i) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		price[6] = Integer.parseInt(br.readLine());

		Map<Character, Integer> ctoi = new HashMap<>();
		ctoi.put('P', 0);
		ctoi.put('C', 1);
		ctoi.put('V', 2);
		ctoi.put('S', 3);
		ctoi.put('G', 4);
		ctoi.put('F', 5);
		ctoi.put('O', 6);

		long ans = 0;
		for (String str : A) {
			char c = str.charAt(0);
			long size = str.length();

			if (c != 'O' && isRecycle(str)) {
				ans += Math.min(price[ctoi.get(c)], price[6]) * size;
			} else
				ans += price[6] * size;

		}

		System.out.println(ans);

	}

	private static boolean isRecycle(String str) {

		int c = str.charAt(0);
		for (int i = 1; i < str.length(); ++i) {
			if (c != str.charAt(i))
				return false;
		}

		return true;
	}

}