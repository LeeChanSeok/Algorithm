import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N, M, ans;
	static String[] board;
	static int[][] D;
	static boolean isCycle;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {

		dfs(0, 0, 1);
		if(isCycle) ans = -1;
		System.out.println(ans);
	}

	private static boolean dfs(int x, int y, int cnt) {

		ans = Math.max(ans, cnt);
		visited[x][y] = true;
		D[x][y] = cnt;
		
		if(cnt > N * M) {
			isCycle = true;
			return true;
		}
		
		int X = (int)(board[x].charAt(y) - '0');
		
		for(int d = 0; d < 4; ++d) {
			int nx = x + dx[d]*X;
			int ny = y + dy[d]*X;
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(visited[nx][ny]) {
				isCycle = true;
				return true;
			}

			char nX = board[nx].charAt(ny);
			if(nX == 'H') continue;
			if(D[nx][ny] >= cnt + 1) continue;
			
			if(dfs(nx, ny, cnt + 1)) return true;
		}
		
		visited[x][y] = false;
		return false;
	}

	private static void input() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new String[N];
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine();
		}
		
		visited = new boolean[N][M];
		D = new int[N][M];
		
	}

}