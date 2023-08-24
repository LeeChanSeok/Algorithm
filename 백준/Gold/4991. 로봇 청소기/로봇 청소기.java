import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int w, h, ans;
	static char[][] board;
	static int[][] dist;
	static int dirtyCnt;
	static int[][] dirtyPos;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		while(input()) {
			int res = pos();
			sb.append(res).append('\n');
		}
		System.out.println(sb);
	}

	private static int pos() {
		
		findStartPos();
		findDirtyPos();

		dist = new int[dirtyCnt][dirtyCnt];
		
		for(int i = 0; i < dirtyCnt - 1; ++i) {
			for(int j = i + 1; j < dirtyCnt; ++j) {
				dist[i][j] = dist[j][i] = bfs(i, j);
				if(dist[i][j] == -1) return -1;
			}
		}
		
		ans = Integer.MAX_VALUE;
		recursive(0, 1, 1, 0);
		return ans;
		
	}

	private static void recursive(int idx, int cnt, int flag, int total) {

		if(total > ans) return;
		
		if(cnt == dirtyCnt) {
			ans = total; 
			return;
		}
		
		for(int i = 1; i < dirtyCnt; ++i) {
			if(((1 << i) & flag) != 0) continue;
			
			recursive(i, cnt + 1, flag | (1 << i), total + dist[idx][i]);
		}
		
	}

	private static int bfs(int s, int e) {

		int sx = dirtyPos[s][0];
		int sy = dirtyPos[s][1];
		int ex = dirtyPos[e][0];
		int ey = dirtyPos[e][1];
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sx, sy});

		boolean[][] visited = new boolean[h][w];
		visited[sx][sy] = true;
		
		int move = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-- > 0) {
				int[] cur = q.poll();
				if(cur[0] == ex && cur[1] == ey) return move;
				
				for(int d = 0; d < 4; ++d) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					
					if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					if(board[nx][ny] == 'x') continue;
					if(visited[nx][ny]) continue;
					
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
			
			++move;
		}
		
		return -1;
	}

	private static boolean input() throws Exception {
		
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		if(w == 0 && h == 0) return false;
		
		board = new char[h][w];
		for(int i = 0; i < h; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		dirtyCnt = 0;
		dirtyPos = new int[11][2];
		return true;
		
	}

	private static void findDirtyPos() {
		
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				if(board[i][j] == '*') {
					dirtyPos[dirtyCnt][0] = i;
					dirtyPos[dirtyCnt++][1] = j;
				}
			}
		}
		
	}

	private static void findStartPos() {
		
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < w; ++j) {
				if(board[i][j] == 'o') {
					dirtyPos[dirtyCnt][0] = i;
					dirtyPos[dirtyCnt++][1] = j;
					return;
				}
			}
		}
		
	}

}