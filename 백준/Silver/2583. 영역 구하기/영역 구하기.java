import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int M, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[M+1][N+1];
		for(int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int ly = Integer.parseInt(st.nextToken());
			int lx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			
			++board[lx][ly]; ++board[rx][ry]; 
			--board[lx][ry]; --board[rx][ly];
			
		}
		
		for(int i = 0; i < M; ++i) {
			for(int j = 1; j < N; ++j) {
				board[i][j] += board[i][j-1];
			}
		}
		
		for(int j = 0; j < N; ++j) {
			for(int i = 1; i < M; ++i) {
				board[i][j] += board[i-1][j];
			}
		}
		
		List<Integer> empty_space = new LinkedList<>();
		boolean[][] visit = new boolean[M][N];
		for(int i = 0; i < M; ++i) {
			for(int j = 0; j < N; ++j) {
				if(board[i][j] != 0 || visit[i][j]) continue;
				empty_space.add(bfs(i, j, M, N, board, visit));
			}
		}
		
		empty_space.sort((l1, l2) -> l1-l2);
		System.out.println(empty_space.size());
		for(int s : empty_space) System.out.print(s + " ");
		
	}

	private static int bfs(int r, int c, int M, int N, int[][] board, boolean[][] visit) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		
		visit[r][c] = true;
		int cnt = 1;
		int[] cur;
		int x, y, nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			x = cur[0]; y = cur[1];
			
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N || board[nx][ny] != 0 || visit[nx][ny]) continue;
				
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
				++cnt;
			}
		}
		
		return cnt;
	}

}