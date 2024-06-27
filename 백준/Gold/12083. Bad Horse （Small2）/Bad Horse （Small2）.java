import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int size;
	static Map<String, Set<String>> troubles;
	static Set<String> A, B;
	static List<String> names;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			M = Integer.parseInt(br.readLine());

			troubles = new HashMap<>();
			A = new HashSet<>();
			B = new HashSet<>();
			names = new ArrayList<>();

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());

				String name1 = st.nextToken();
				String name2 = st.nextToken();

				if (!troubles.containsKey(name1)) {
					Set<String> set = new HashSet<>();
					troubles.put(name1, set);
					names.add(name1);
				}
				troubles.get(name1).add(name2);

				if (!troubles.containsKey(name2)) {
					Set<String> set = new HashSet<>();
					troubles.put(name2, set);
					names.add(name2);
				}
				troubles.get(name2).add(name1);

			}

			size = names.size();
			String res = "No";
			if (solution(0))
				res = "Yes";

			sb.append(String.format("Case #%d: %s\n", t, res));

		}

		System.out.println(sb);

	}

	private static boolean solution(int idx) {

		if (idx == size)
			return true;

		String name = names.get(idx);

		if (isGroup(name, A)) {
			A.add(name);
			if(solution(idx + 1)) return true;
			A.remove(name);
		}

		if (isGroup(name, B)) {
			B.add(name);
			if(solution(idx + 1)) return true;
			B.remove(name);
		}

		return false;
	}

	private static boolean isGroup(String name, Set<String> group) {

		Set<String> trouble = troubles.get(name);
		if(trouble.isEmpty()) return false;
		for (String member : group) {
			if (trouble.contains(member))
				return false;
		}
		return true;
	}

}