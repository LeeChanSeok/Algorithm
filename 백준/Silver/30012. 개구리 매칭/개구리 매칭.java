import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] E = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			E[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 1; i <= N; ++i) {
			int dist = Math.abs(E[i] - S);
			int res = 0;
			if (dist >= K * 2) {
				res = (dist - K * 2) * L;
				
			} else {
				int x = dist / 2;
				res = (K - x) * 2 - (dist & 1);
				
			}
			
			if (res < min) {
				min = res;
				idx = i;
			}

		}

		System.out.println(min + " " + idx);
	}

}