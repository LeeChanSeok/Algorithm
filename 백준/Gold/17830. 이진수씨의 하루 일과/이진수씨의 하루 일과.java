import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb1, sb2;
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			String B = st.nextToken();
			int ans1 = 0, ans2 = 0;

			boolean isMax = false, isMin = false;
			int maxIdx = 0, minIdx = 0;
			for (int i = N - 1; i >= 0; --i) {
				char c = B.charAt(i);
				if (c == '1') {
					if (maxIdx != 0)
						isMax = true;
					if (minIdx != 0)
						isMin = true;

					maxIdx = minIdx = N - i;
				} else if (c == '?') {
					if (maxIdx != 0)
						isMax = true;
					maxIdx = N - i;
				}
			}
			
			if(maxIdx == 0) {
				ans1 = 1;
			} else {
				ans1 = isMax ? maxIdx + N : maxIdx + N - 1;
			}
			
			if(minIdx == 0) {
				ans2 = 1;
			} else {
				ans2 = isMin ? minIdx + N : minIdx + N - 1;
			}
			
			bw.write(ans1 + " " + ans2 + "\n");

		}

		bw.flush();

	}

}