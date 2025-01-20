import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int Q = Integer.parseInt(br.readLine());
		Map<String, PriorityQueue<Integer>> map = new HashMap<>();

		long ans = 0;
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pq;

			if (cmd == 1) {

				if (!map.containsKey(name)) {
					pq = new PriorityQueue<>((a, b) -> b - a);
				} else {
					pq = map.get(name);
				}

				for (int i = 0; i < k; ++i) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}

				map.put(name, pq);
			} else if (cmd == 2) {
				if (map.containsKey(name)) {
					pq = map.get(name);
					while (k-- > 0 && !pq.isEmpty()) {
						ans += pq.poll();
					}
					
					map.put(name, pq);
				}
			}

		}

		System.out.println(ans);

	}

}