import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[] str = st.nextToken().toCharArray();

			char[][] arr = new char[R][C];
			int idx = 0;
			for (int i = 0; i < R; ++i) {
				for (int j = 0; j < C; ++j) {
					arr[i][j] = str[idx++];
				}
			}

			String msg = "";
			int x = 0, y = 0, d = 0;
			for (int i = 0; i < R * C; ++i) {
				msg += arr[x][y];
				arr[x][y] = '2';

				int nx = x + dx[d];
				int ny = y + dy[d];
				if ((nx < 0 || nx >= R || ny < 0 || ny >= C) || arr[nx][ny] == '2') {
					d = (d + 1) % 4;
					nx = x + dx[d];
					ny = y + dy[d];
				}

				x = nx;
				y = ny;
			}

			int q = msg.length() / 5;
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < q; ++i) {
				String sub = msg.substring(i * 5, i * 5 + 5);
				int num = Integer.parseInt(sub, 2);

				char c = ' ';
				if (num != 0)
					c = (char) (num + 'A' - 1);
				tmp.append(c);

			}
			sb.append(tmp.toString().trim()).append('\n');

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}