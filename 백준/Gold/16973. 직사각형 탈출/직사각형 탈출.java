import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int ans;
	static int N, M;
	static int H, W, sr, sc, fr, fc;
	static char[][] board;
	static List<int[]> walls;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();

	}

	private static void pro() {
		System.out.println(bfs());
	}

	private static int bfs() {

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sr, sc});
		
		boolean[][] visited = new boolean[N][M];
		visited[sr][sc] = true;
		
		int move = 0;
		
		while(!q.isEmpty()) {
			
			int qSize = q.size();
			while(qSize-- > 0) {
				int[] cur = q.poll();
				
				int x = cur[0];
				int y = cur[1];
				if(x == fr && y == fc) return move;
				
				for(int d = 0; d < 4; ++d) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(nx + H > N | ny + W > M) continue;
					
					if(visited[nx][ny]) continue;
					
					if(inWall(nx ,ny)) continue;
					
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
			
			++move;
		}
		
		return -1;
		
	}

	private static boolean inWall(int x, int y) {

		for(int[] wall : walls) {
			int wx = wall[0]; int wy = wall[1];
			
			if(wx >= x && wx < x + H 
					&& wy >= y && wy < y + W) return true;
		}
	
		return false;

	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		walls = new LinkedList<>();
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				board[i][j] = st.nextToken().charAt(0);
				if(board[i][j] == '1') walls.add(new int[] {i, j});
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		fr = Integer.parseInt(st.nextToken()) - 1;
		fc = Integer.parseInt(st.nextToken()) - 1;
		
	}

}