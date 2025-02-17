import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int MAXK = 200000;
		
		int[] ans = new int[N];

		Set<Integer>[] set = new Set[MAXK + 1];
		for(int i = 1; i <= MAXK; ++i) {
			set[i] = new TreeSet<>((a, b) -> a - b);
		}
		
		for (int i = 0; i < N; ++i) {

			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; ++j) {
				int num = Integer.parseInt(st.nextToken());
				set[num].add(i);
			}
		}
		

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			int num = Integer.parseInt(st.nextToken());
			
			if(!set[num].isEmpty()) {
				int k = set[num].iterator().next();
				set[num].remove(k);
				++ans[k];
			}
		}

		for (int i = 0; i < N; ++i) {
			sb.append(ans[i] + " ");
		}

		System.out.println(sb);

	}

}