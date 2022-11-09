import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Ball{
		int x, y;

		public Ball(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int N, M, min, maxIdx;
	static Ball[] ball;
	static char[][] board;
	static int[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i = 0; i < N; ++i)
			board[i] = br.readLine().toCharArray();
		
		ball = new Ball[2];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == 'R') {
					ball[0] = new Ball(i, j);
					board[i][j] = '.';
				}else if(board[i][j] == 'B') {
					ball[1] = new Ball(i, j);
					board[i][j] = '.';
				}
			}
		}

		int INF = Integer.MAX_VALUE;
		maxIdx = N*M + 1;
		visit = new int[maxIdx][maxIdx];
		for(int i = 0; i < maxIdx; ++i)
			Arrays.fill(visit[i], INF);
		
		visit[ball[0].x*M + ball[0].y][ball[1].x*M + ball[1].y] = 0;
		
		int ans = 0;
		if(dfs(0)) ans = 1;
		System.out.println(ans);
		
	}
	
	private static boolean dfs(int cnt) {
		
		int rx, ry, bx, by;
		int nrx, nry, nbx, nby;
		int nrPos, nbPos;
		
		rx = ball[0].x; ry = ball[0].y;
		bx = ball[1].x; by = ball[1].y;
		
		if(cnt == 10) return false;
				
		boolean rHole, bHole;
		
		for(int d = 0; d < 4; ++d) {
			nrx = rx;	nry = ry;
			nbx = bx;	nby = by;
			
			// 해당 방향으로 이동.
			while(board[nrx][nry] == '.') {
				nrx += dx[d]; nry += dy[d];
			}
			
			rHole = false;
			if(board[nrx][nry] == '#') {
				nrx -= dx[d];
				nry -= dy[d];
			}else if(board[nrx][nry] == 'O') rHole = true;
			
			// 해당 방향으로 이동.
			while(board[nbx][nby] == '.') {
				nbx += dx[d]; nby += dy[d];
			}
			
			bHole = false;
			if(board[nbx][nby] == '#') {
				nbx -= dx[d];
				nby -= dy[d];
			}else if(board[nbx][nby] == 'O') bHole = true;
			
			if(bHole) continue;
			if(rHole) return true;
			
			// R == B
			if(nrx == nbx && nry == nby) {
				if(d == 0) {
					if(rx < bx) nbx -= dx[d];
					else nrx -= dx[d];
				}else if(d == 1) {
					if(rx < bx) nrx -= dx[d];
					else nbx -= dx[d];
				}else if(d == 2) {
					if(ry < by) nby -= dy[d];
					else nry -= dy[d];
				}else if(d == 3) {
					if(ry < by) nry -= dy[d];
					else nby -= dy[d];
				}
			}
			
			nrPos = nrx*M + nry;
			nbPos = nbx*M + nby;
			
			if(visit[nrPos][nbPos] > cnt+1) {
				visit[nrPos][nbPos] = cnt+1;
				ball[0].x = nrx; ball[0].y = nry;
				ball[1].x = nbx; ball[1].y = nby;
				if(dfs(cnt+1)) return true;
				ball[0].x = rx; ball[0].y = ry;
				ball[1].x = bx; ball[1].y = by;
			}
			
		}
		
		return false;
		
	}
	
}