import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			long aa = (a * a) + ((b + c) * (b + c));
			long bb = (b * b) + ((a + c) * (a + c));
			long cc = (c * c) + ((b + a) * (b + a));

			sb.append(Math.min(aa, Math.min(bb, cc))).append('\n');
		}

		System.out.println(sb);

	}

}