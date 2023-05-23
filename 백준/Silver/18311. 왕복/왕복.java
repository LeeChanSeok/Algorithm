import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		int[] dist = new int[2 * N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N + 1; i <= 2 * N; ++i)
			dist[i] = dist[2 * N - i + 1];


		TreeMap<Long, Integer> treeMap = new TreeMap<>();

		int idx = 0;
		long len = 0;
		for (int i = 0; i <= N; ++i) {
			treeMap.put(len, idx++);
			len += dist[i];
		}
		for (int i = N; i > 0; --i) {
			treeMap.put(len, --idx);
			len += dist[i];
		}

		if (K <= N)
			if (treeMap.containsKey(K))
				System.out.print(treeMap.get(K));
			else
				System.out.print(treeMap.get(treeMap.lowerKey(K)));
		else 
			if (treeMap.containsKey(K))
				System.out.print(treeMap.get(K));
			else
				System.out.print(treeMap.get(treeMap.lowerKey(K)));
	}

}
