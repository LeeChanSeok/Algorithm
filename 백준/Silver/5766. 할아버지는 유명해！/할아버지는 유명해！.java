import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N, M, player;
		Map<Integer, Integer> ranks;
		List<int[]> list;
		while (true) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;
			ranks = new HashMap<>();

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; ++j) {
					player = Integer.parseInt(st.nextToken());
					int cnt = ranks.getOrDefault(player, 0) + 1;
					ranks.put(player, cnt);
				}
			}
			list = new LinkedList<>();
			for (Entry<Integer, Integer> entry : ranks.entrySet()) {
				list.add(new int[] { entry.getKey(), entry.getValue() });
			}

			list.sort((l1, l2) -> {
				if (l1[1] == l2[1])
					return l1[0] - l2[0];
				return l2[1] - l1[1];
			});

			int[] top = list.remove(0);
			int rank = list.get(0)[1];

			for (int[] p : list) {
				if (p[1] == rank)
					sb.append(p[0] + " ");
				else
					break;
			}
			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}
