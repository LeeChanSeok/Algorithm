import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static int n, k;
	static String[] arr;
	static Set<Integer> res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		arr = new String[n];

		for (int i = 0; i < n; ++i) {
			arr[i] = br.readLine();
		}

		res = new HashSet<>();
		recursive(0, 0, "");

		System.out.println(res.size());
	}

	private static void recursive(int flag, int cnt, String str) {

		if (cnt == k) {
			res.add(Integer.parseInt(str));
			return;
		}

		for (int i = 0; i < n; ++i) {
			if ((flag & (1 << i)) != 0)
				continue;

			recursive(flag | (1 << i), cnt + 1, str + arr[i]);
		}

	}

}