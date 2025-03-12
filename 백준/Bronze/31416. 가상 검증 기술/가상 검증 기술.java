import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int Ta = Integer.parseInt(st.nextToken());
			int Tb = Integer.parseInt(st.nextToken());
			int Va = Integer.parseInt(st.nextToken());
			int Vb = Integer.parseInt(st.nextToken());

			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= Va; i++) {
				min = Math.min(min, Math.max(Ta * i, Ta * (Va - i) + Tb * Vb));
			}
			sb.append(min).append("\n");
		}

		System.out.println(sb);

	}

}