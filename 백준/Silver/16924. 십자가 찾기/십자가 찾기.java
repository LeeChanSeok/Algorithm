import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, m;
	static char[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		
		int k = 0;
		for(int i = 1; i < n-1; ++i) {
			for(int j = 1; j < m-1; ++j) {
				if(board[i][j] != '*') continue;
				
				int s = 1;
				while(inRange(i, j, s)) {
					isVisited(i, j, s);
					++s;
				}
				
				if(s != 1) {
					++k;
					sb.append(String.format("%d %d %d\n", i+1, j+1, s-1));
				}
			}
		}
		
		if(!isAnswer()) System.out.println(-1);
		else {
			System.out.println(k);
			System.out.println(sb);
		}
		
	}

	private static boolean isAnswer() {

		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(board[i][j] == '*' && !visited[i][j]) return false;
			}
		}
		return true;
	}

	private static void isVisited(int x, int y, int s) {
		
		visited[x][y] = true;
		for(int d = 0; d < 4; ++d) {
			int nx = x + dx[d] * s;
			int ny = y + dy[d] * s;
			
			visited[nx][ny] = true;
			
		}
		
	}

	private static boolean inRange(int x, int y, int s) {

		for(int d = 0; d < 4; ++d) {
			int nx = x + dx[d] * s;
			int ny = y + dy[d] * s;
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) return false;;
			if(board[nx][ny] != '*') return false;
			
		}
		
		return true;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char[n][m];
		for(int i = 0; i < n; ++i) board[i] = br.readLine().toCharArray();
		
		visited = new boolean[n][m];
	}

}