import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		int min = 100, max = 1;
		int num;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				min = Math.min(min, num);
				max = Math.max(max, num);
			}
		}
		
		int safe_area;
		int ans = 1;
		boolean[][] visit;
		for(int h = min; h < max; ++h) {
			
			safe_area = 0;
			visit = new boolean[N][N];
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(board[i][j] <= h || visit[i][j]) continue;
					bfs(i, j, h, N, board, visit);
					++safe_area;
				}
			}
			
			ans = Math.max(ans, safe_area);
			
		}

		System.out.println(ans);
	}

	private static void bfs(int i, int j, int h, int N, int[][] board, boolean[][] visit) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		
		visit[i][j] = true;
		
		int[] cur;
		int x, y, nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			x = cur[0]; y = cur[1];
			
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || board[nx][ny] <= h) continue;
				
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
			}
		}
		
	}

}