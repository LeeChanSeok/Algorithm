import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		long total = 0;
		long ans = 0;
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			total += num;

			int cnt = map.getOrDefault(num, 0) + 1;
			map.put(num, cnt);
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			long k = entry.getKey();
			long v = entry.getValue();

			ans += ( v * (v - 1) / 2) * k * k ;
			total -= k * v;
			ans += k * v * total;

		}

		System.out.println(ans);

	}

}