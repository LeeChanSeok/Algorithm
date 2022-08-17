import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int N;
	public static int[] dx = { 0, 0, 1, 1 };
	public static int[] dy = { 0, 1, 0, 1 };
	public static char[][] map;
	public static StringBuffer sb;

	public static boolean compression(int N, int x, int y) {

		char bit = map[x][y];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[x + i][y + j] != bit)
					return false;
			}
		}

		return true;
	}

	public static void QuardTree(int N, int x, int y) {
		
		if (compression(N, x, y)) {
			sb.append(map[x][y]);
			return;
		}
		sb.append('(');
		
		for(int d = 0, dSize = dx.length; d < dSize; d++) {
			QuardTree(N/2, x + dx[d]*N/2 , y + dy[d]*N/2);
		}
		sb.append(')');
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		sb = new StringBuffer();
		QuardTree(N, 0, 0);
		System.out.println(sb.toString());

	}

}