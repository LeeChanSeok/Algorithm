import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int INF = Integer.MAX_VALUE;
	static int n, m, ans;
	static int[][] board;
	static List<int[]> mPnt;
	static int mCnt;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
	}

	private static void pro() {
		
		ans = INF;
		recursive(0, 0, 0);
		if(ans == INF) ans = -1;
		
		System.out.println(ans);
		
	}
	

	private static void recursive(int cnt, int idx, int flag) {

		if(cnt == m) {
			int res = bfs(flag);
			ans = Math.min(ans, res);
			return;
		}
		
		for(int i = idx; i < mCnt; ++i) {
			if(((1 << i) & flag) == 0) {
				recursive(cnt + 1, i + 1, flag | (1 << i));
			}
		}
		
	}

	private static int bfs(int flag) {

		int[][] visited = new int[n][n];
		for(int i = 0; i < n; ++i) {
			Arrays.fill(visited[i], INF);
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < mCnt; ++i) {
			if(((1 << i) & flag) != 0) {
				int[] pnt = mPnt.get(i);
				q.offer(pnt);
				visited[pnt[0]][pnt[1]] = 0;
			}
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			++cnt;
			
			while(qSize-- > 0) {
				
				int[] cur = q.poll();
				for(int d = 0; d < 4; ++d) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if(visited[nx][ny] != INF) continue;
					if(board[nx][ny] == 1) continue;
					
					visited[nx][ny] = cnt;
					q.offer(new int[] {nx, ny});
				}
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(board[i][j] != 1 && visited[i][j] == INF) return INF;
			}
		}
		
		return cnt - 1;
	}

	private static void input() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		mPnt = new ArrayList<>();
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(board[i][j] == 2) mPnt.add(new int[] {i, j});
			}
		}
	
		mCnt = mPnt.size();
		
	}


}