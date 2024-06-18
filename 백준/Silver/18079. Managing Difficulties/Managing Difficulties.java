import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			Map<Integer, ArrayList<Integer>> map = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;

				if (map.containsKey(num))
					map.get(num).add(i);
				else {
					ArrayList list = new ArrayList<Integer>();
					list.add(i);

					map.put(num, list);

				}
			}

			int ans = 0;

			for (int i = 0; i < N - 2; ++i) {
				for (int j = i + 1; j < N - 1; ++j) {
					int a1 = arr[i];
					int a2 = arr[j];
					int a3 = a2 * 2 - a1;

					if (map.containsKey(a3)) {
						ArrayList<Integer> list = map.get(a3);

						int idx = binarySearch(list, j);
						ans += list.size() - idx;
					}
				}
			}

			sb.append(ans).append('\n');

		}

		System.out.println(sb);

	}

	private static int binarySearch(ArrayList<Integer> list, int target) {

		int size = list.size();
		if (list.get(size - 1) <= target)
			return size;

		int l = 0;
		int r = size - 1;
		int res = size - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			int v = list.get(mid);
			if (v > target) {
				res = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return res;
	}

}