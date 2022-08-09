import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		int N, i, ans;
		char[] arr;
		List<Character> operator = new ArrayList<>(4);
		operator.add('+');
		operator.add('-');
		operator.add('*');
		operator.add('/');

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N + 1];
			ans = 1;
			for (i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
				if (!operator.contains(arr[i]) && st.hasMoreTokens()) {
					ans = 0;
					break;
				}

			}
			while (++i <= N) br.readLine();			
			System.out.printf("#%d %d\n", tc, ans);

		} // test-cast 종료
	}
}