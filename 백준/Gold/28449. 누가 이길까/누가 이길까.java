import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 0);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			int cnt = map.getOrDefault(num, 0) + 1;
			map.put(num, cnt);
		}

		int sum = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int k = entry.getKey();
			int v = entry.getValue();

			sum += v;
			map.put(k, sum);
		}

		long win = 0, lose = 0, draw = 0;
		for (int num : A) {

			int lk = map.lowerKey(num);
			int wCnt = map.get(lk);

			win += wCnt;
			if (map.containsKey(num)) {
				draw += map.get(num) - map.get(lk);
			}

		}

		long total = (long) N * M;
		lose = total - win - draw;

		System.out.println(win + " " + lose + " " + draw);

	}

}