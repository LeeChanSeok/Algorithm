import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int R, C, ans;
	static int nr, nc;
	static char[][] map;
	static int[] dr = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();

		for (int i = 0; i < R; i++) 
            dfs(i, 0);
		
		System.out.println(ans);
	}

	public static boolean dfs(int r, int c) {

		map[r][c] = 'x';
		if (c == C - 1) {
			ans++;
			return true;
		}

		for (int d = 0, dSize = dr.length; d < dSize; d++) {
			nr = r + dr[d];
			nc = c + 1;
			if (nr < 0 || nr >= R || map[nr][nc] == 'x')	continue;
			if (dfs(nr, nc)) return true;
		}
		return false;
	}

}