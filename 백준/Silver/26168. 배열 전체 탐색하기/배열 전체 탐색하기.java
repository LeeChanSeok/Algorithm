import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static int N, M;
	static TreeMap<Long, Long> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new TreeMap<>();

		st = new StringTokenizer(br.readLine());
		map.put(0l, 0l);
		for (int i = 0; i < N; ++i) {
			long num = Long.parseLong(st.nextToken());

			long cnt = map.getOrDefault(num, 0l) + 1;
			map.put(num, cnt);
		}

		long prev = 0;
		for (Entry<Long, Long> entry : map.entrySet()) {
			long k = entry.getKey();
			long v = entry.getValue();

			prev += v;
			map.put(k, prev);
		}

		long res;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {

				long k = Long.parseLong(st.nextToken());
				res = N - map.get(map.lowerKey(k));
				bw.write(res + "\n");

			} else if (cmd == 2) {
				long k = Long.parseLong(st.nextToken());
				res = N - map.get(map.floorKey(k));
				bw.write(res + "\n");

			} else {

				long a = Long.parseLong(st.nextToken());
				long b = Long.parseLong(st.nextToken());

				res = map.get(map.floorKey(b)) - map.get(map.lowerKey(a));
				bw.write(res + "\n");
			}

		}

		bw.flush();
	}

}