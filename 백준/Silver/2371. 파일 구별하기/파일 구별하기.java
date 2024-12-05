import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer>[] lists;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		lists = new List[N];
		for (int i = 0; i < N; ++i) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int num;
			while ((num = Integer.parseInt(st.nextToken())) != -1) {
				lists[i].add(num);
			}
		}

		int k = 0;
		while (!isDistinct(k++));

		System.out.println(k);
	}

	private static boolean isDistinct(int k) {
		Set<Integer> set = new HashSet<>();
		for (List<Integer> list : lists) {
			if (list.size() > k) {
				if (set.contains(list.get(k)))
					return false;
				set.add(list.get(k));
			}

		}
		return true;
	}

}