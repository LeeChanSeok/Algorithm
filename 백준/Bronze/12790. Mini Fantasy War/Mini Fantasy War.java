import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int HP1 = Integer.parseInt(st.nextToken());
			int MP1 = Integer.parseInt(st.nextToken());
			int S1 = Integer.parseInt(st.nextToken());
			int D1 = Integer.parseInt(st.nextToken());

			int HP2 = Integer.parseInt(st.nextToken());
			int MP2 = Integer.parseInt(st.nextToken());
			int S2 = Integer.parseInt(st.nextToken());
			int D2 = Integer.parseInt(st.nextToken());

			int ans = Math.max(HP1 + HP2, 1) + Math.max(MP1 + MP2, 1) * 5 + Math.max(S1 + S2, 0) * 2 + (D1 + D2) * 2;
			bw.write(ans + "\n");

		}

		bw.flush();
	}

}