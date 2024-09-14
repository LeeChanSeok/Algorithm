import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Set<Integer> tset = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			tset.add(num);
		}

		Set<Integer> kset = new HashSet<>();
		for (int i = 1; i <= N / 2; ++i) {
			kset.add(arr[i] - arr[0]);
		}

		int cnt = 0;
		List<Integer> list = new ArrayList<>();

		for (int k : kset) {

			boolean flag = true;
			for (int i = 0; i < N; ++i) {
				if (tset.contains(arr[i] - k))
					continue;
				if (tset.contains(arr[i] + k))
					continue;

				flag = false;
				break;
			}

			if (flag) {
				++cnt;
				list.add(k);
			}

		}

		sb.append(cnt).append('\n');
		Collections.sort(list);
		for (int num : list) {
			sb.append(num + " ");
		}

		System.out.println(sb);

	}

}