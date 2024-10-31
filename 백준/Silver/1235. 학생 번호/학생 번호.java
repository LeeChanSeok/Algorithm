import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] arr = new String[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = br.readLine();
		}

		int ans = solution(arr, N);
		System.out.println(ans);
	}

	private static int solution(String[] arr, int N) {
		int len = arr[0].length() - 1;

		for (int i = len; i >= 0; --i) {
			Set<String> set = new HashSet<>();
			for (int j = 0; j < N; ++j) {
				String sub = arr[j].substring(i);
				if (set.contains(sub))
					break;
				set.add(sub);
			}

			if (set.size() == N)
				return (len - i + 1);
		}
		return len;
	}

}