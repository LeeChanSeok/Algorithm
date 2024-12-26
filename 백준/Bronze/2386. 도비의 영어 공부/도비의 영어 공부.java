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

		String str;
		int cnt;
		while (true) {
			st = new StringTokenizer(br.readLine());

			int c = st.nextToken().charAt(0);
			if (c == '#')
				break;

			str = null;
			cnt = 0;

			while (st.hasMoreTokens()) {
				str = st.nextToken().toLowerCase();

				for (int i = 0; i < str.length(); ++i) {
					if (str.charAt(i) == c)
						++cnt;
				}
			}

			bw.write(String.format("%c %d\n", c, cnt));
		}

		bw.flush();
	}

}