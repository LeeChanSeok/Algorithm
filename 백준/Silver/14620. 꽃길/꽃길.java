import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	static int n, ans;
	static int[][] board;
	static int[][] cost;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		calc_cost();
		
		ans = Integer.MAX_VALUE;
		dfs(0, 1, 1, 0);
		System.out.println(ans);
		
	}

	private static void calc_cost() {
		
		for(int i = 1; i < n - 1; ++i) {
			for(int j = 1; j < n - 1; ++j) {
				for(int d = 0; d <= 4; ++d) {
					cost[i][j] += board[i+dx[d]][j+dy[d]];
				}
			}
		}
		
	}

	private static void dfs(int cnt, int x, int y, int total) {

		
		if(total >= ans) return;
		
		if(cnt == 3) {
			ans = total;
			return;
		}
		
		if(y >= n - 1) {
			++x; y = 1;
			if(x == n - 1) return;
		}
		
		if(isGood(x, y)) {
			visit(x,y);
			dfs(cnt + 1, x, y + 3, total + cost[x][y]);
			unVisit(x,y);
		}
		
		dfs(cnt, x, y + 1, total);
		
	}

	private static void visit(int x, int y) {
		
		for(int d = 0; d <= 4; ++d) {
			visited[x + dx[d]][y + dy[d]] = true;
		}
	}
	
	private static void unVisit(int x, int y) {
		
		for(int d = 0; d <= 4; ++d) {
			visited[x + dx[d]][y + dy[d]] = false;
		}
	}
	private static boolean isGood(int x, int y) {

		for(int d = 0; d <= 4; ++d) {
			if(visited[x + dx[d]][y + dy[d]]) return false;
		}
		
		return true;
	}

	private static void input() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		cost = new int[n][n];
		
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}