import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int N = 5;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] arr = new int[N][N];
	static boolean[][] visited = new boolean[N][N];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		char ans = '0';
		if(solution(x, y, 0, 0)) ans = '1';
		System.out.println(ans);
				
	}

	private static boolean solution(int x, int y, int cnt, int move) {

		if(move == 4) return false;
		
		visited[x][y] = true;
		if(arr[x][y] == 1) ++cnt;		
		if(cnt == 2) return true;
		
		for(int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(arr[nx][ny] == -1) continue;
			if(visited[nx][ny]) continue;
			
			if(solution(nx, ny, cnt, move + 1)) return true;
			
		}
		
		visited[x][y] = false;
		return false;
	}

}