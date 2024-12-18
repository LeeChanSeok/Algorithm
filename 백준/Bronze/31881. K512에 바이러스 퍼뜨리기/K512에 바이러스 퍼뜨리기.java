import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		boolean[] used = new boolean[N + 1];

		int cnt = N;
		for (int i = 0; i < Q; ++i) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int num = Integer.parseInt(st.nextToken());
				if (!used[num]) {
					--cnt;
					used[num] = true;
				}
			} else if (cmd == 2) {
				int num = Integer.parseInt(st.nextToken());
				if (used[num]) {
					++cnt;
					used[num] = false;
				}
			} else
				bw.write(cnt + "\n");
		}
		bw.flush();
	}

}