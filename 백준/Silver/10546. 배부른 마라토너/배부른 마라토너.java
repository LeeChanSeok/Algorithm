import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; ++i) {
			String name = br.readLine();
			int cnt = map.getOrDefault(name, 0);
			map.put(name, cnt + 1);
		}
		
		for (int i = 1; i < N; ++i) {
			String name = br.readLine();
			int cnt = map.getOrDefault(name, 0);

			if (cnt == 1)
				map.remove(name);
			else {
				map.put(name, cnt - 1);
			}
		}

		System.out.println(map.keySet().iterator().next());
	}

}