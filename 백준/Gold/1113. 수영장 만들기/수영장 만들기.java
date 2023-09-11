import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, m;
	static int min, max;
	static int[][] board;
	static boolean[][] isFull;
	static int DELTA = 100;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		int ans = 0;
		for(int h = min + 1; h <= max; ++h) {
			for(int i = 1; i < n - 1; ++i) {
				for(int j = 1; j < m - 1; ++j) {
					if(board[i][j] < h) ans += bfs(i, j, h);
				}
			}
		}
		
		System.out.println(ans);
	}

	private static int bfs(int sx, int sy, int h) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(sx * DELTA + sy);
		
		++board[sx][sy];
		int cnt = 1;
		boolean isPull = false;
		
		while(!q.isEmpty()) {
			int pos = q.poll();
			int x = pos / DELTA;
			int y = pos % DELTA;
			
			for(int d = 0; d < 4; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) isPull = true;
				else if(board[nx][ny] < h) {
					++board[nx][ny];
					cnt++;
					q.offer(nx * DELTA + ny);
				}
				
			}
		}
		if(isPull) cnt = 0;
		return cnt;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		min = 9; max = 0;
		board = new int[n][m];
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < m; ++j) {
				board[i][j] = str.charAt(j) - '0';
				max = Math.max(board[i][j], max);
				min = Math.min(board[i][j], min);
			}
		}

		isFull = new boolean[n][m];
	}

}