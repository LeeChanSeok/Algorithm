import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	
	}
	static final int N = 5;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int haveToMove, ans;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		visit = new boolean[N][N];
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			visit[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
		}
		
		ans = 0;
		haveToMove = (N*N - K)/2;
		
		Point Jun = new Point(0, 0);
		Point Hye = new Point(N-1, N-1);
		visit[Jun.x][Jun.y] = visit[Hye.x][Hye.y] = true;
		dfs(0, Jun, Hye);
		System.out.println(ans);
		
	}
	private static void dfs(int move, Point jun, Point hye) {

		if(jun.x == hye.x && jun.y == hye.y) {
			if(move == haveToMove) {
				++ans;
			}		
			return;
		}
		
		if(move == haveToMove) {
			return;
		}
		
		Point nextJun, nextHye;
		
		int jnx, jny, hnx, hny;
		for(int d1 = 0; d1 < 4; ++d1) {
			jnx = jun.x + dx[d1];
			jny = jun.y + dy[d1];
			
			if(jnx < 0 || jnx >= N || jny < 0 || jny >= N || visit[jnx][jny]) continue;
			
			for(int d2 = 0; d2 < 4; ++d2) {
				hnx = hye.x + dx[d2];
				hny = hye.y + dy[d2];
				
				if(hnx < 0 || hnx >= N || hny < 0 || hny >= N || visit[hnx][hny]) continue;

				nextJun = new Point(jnx, jny);
				nextHye = new Point(hnx, hny);
				
				visit[nextJun.x][nextJun.y] = visit[nextHye.x][nextHye.y] = true;
				dfs(move+1, nextJun, nextHye);
				visit[nextJun.x][nextJun.y] = visit[nextHye.x][nextHye.y] = false;
			}
		}
		
	}

}