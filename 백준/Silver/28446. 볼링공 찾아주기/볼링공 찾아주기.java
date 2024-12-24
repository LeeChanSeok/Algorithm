import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int v = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());

				map.put(k, v);
			} else {
				int k = Integer.parseInt(st.nextToken());
				bw.write(map.get(k) + "\n");
			}
		}

		bw.flush();

	}

}