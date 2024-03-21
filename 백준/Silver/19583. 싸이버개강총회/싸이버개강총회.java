import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int delta = 60;

		String[] SS = st.nextToken().split(":");
		String[] SE = st.nextToken().split(":");
		String[] SQ = st.nextToken().split(":");

		int S = Integer.parseInt(SS[0]) * delta + Integer.parseInt(SS[1]);
		int E = Integer.parseInt(SE[0]) * delta + Integer.parseInt(SE[1]);
		int Q = Integer.parseInt(SQ[0]) * delta + Integer.parseInt(SQ[1]);

		int cnt = 0;

		Set<String> set = new HashSet<>();

		String str = null;
		while ((str = br.readLine()) != null) {

			st = new StringTokenizer(str);

			String[] hhss = st.nextToken().split(":");
			int time = Integer.parseInt(hhss[0]) * delta + Integer.parseInt(hhss[1]);

			String name = st.nextToken();

			if (time > Q)
				break;
			else if (time <= S)
				set.add(name);
			else if (time >= E) {
				if (set.contains(name)) {
					++cnt;
					set.remove(name);
				}
			}

		}

		System.out.println(cnt);

	}

}