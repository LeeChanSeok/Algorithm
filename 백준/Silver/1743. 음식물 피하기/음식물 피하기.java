import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static int N, M, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		boolean[][] trash = new boolean[N][M];
		int r, c;
		for(int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			
			trash[r][c] = true;
		}
		
		System.out.println(calc_maxSize(trash));
				
	}

	private static int calc_maxSize(boolean[][] trash) {

		boolean[][] visit = new boolean[N][M];
		
		int maxSize = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(!trash[i][j] || visit[i][j]) continue;
				maxSize = Math.max(maxSize, bfs(i, j, trash, visit));
			}
		}
		
		return maxSize;
	}

	private static int bfs(int i, int j, boolean[][] trash, boolean[][] visit) {

		int cnt = 1;
		visit[i][j] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		int x, y, nx, ny;
		int[] cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			x = cur[0]; y = cur[1];
			
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || !trash[nx][ny] || visit[nx][ny]) continue;
				
				visit[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				++cnt;
			}
		}
		return cnt;
	}

}