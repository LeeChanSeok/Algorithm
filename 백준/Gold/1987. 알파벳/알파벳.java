import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int max;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();

		max = 0;
		dfs(0, 0, 1 << map[0][0] - 'A', 1);
		System.out.println(max);
	}

	static void dfs(int x, int y, int flag, int move) {
		
		max = Math.max(max, move);

		for (int d = 0, dSize = dx.length; d < dSize; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || (flag & 1 << map[nx][ny] - 'A') != 0)	continue;
			dfs(nx, ny, flag | 1 << map[nx][ny] - 'A', move+1);
		}
	}
}