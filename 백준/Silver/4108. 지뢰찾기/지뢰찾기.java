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

		int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

		while (true) {
			st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (R == 0 && C == 0)
				break;

			char[][] arr = new char[R][C];
			for (int i = 0; i < R; ++i) {
				arr[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < R; ++i) {
				for (int j = 0; j < C; ++j) {
					if (arr[i][j] == '*')
						bw.write("*");
					else {
						int cnt = 0;
						for (int k = 0; k < 8; ++k) {
							int nr = i + dr[k];
							int nc = j + dc[k];

							if (nr < 0 || nr >= R || nc < 0 || nc >= C)
								continue;
							if (arr[nr][nc] == '*')
								++cnt;
						}
						bw.write(String.valueOf(cnt));
					}
				}
				bw.write("\n");
			}

		}

		bw.flush();

	}

}