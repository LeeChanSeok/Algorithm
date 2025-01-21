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
		String[] fruits = { "STRAWBERRY", "BANANA", "LIME", "PLUM" };

		Map<String, Integer> map = new HashMap<>();
		for (String fruit : fruits) {
			map.put(fruit, 0);
		}

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			int X = Integer.parseInt(st.nextToken());

			map.put(S, map.get(S) + X);
		}

		String ans = "NO";
		for (String fruit : fruits) {
			if (map.get(fruit) == 5) {
				ans = "YES";

			}
		}
		System.out.println(ans);

	}

}