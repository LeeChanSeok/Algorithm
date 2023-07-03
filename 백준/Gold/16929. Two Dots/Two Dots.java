import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {0, 1, 0, -1};
	static final int[] dy = {1, 0, -1, 0};
	
	static int N, M;
	static char[][] board;
	static char color;
	static boolean[][] visited;
	static int sx, sy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();					
		}
        
		System.out.println(solution());
		
	}

	private static String solution() {
		
		for(int i = 0; i < N-1; ++i) {
			for(int j = 0; j < M-1; ++j) {
				sx = i; sy = j;
				visited = new boolean[N][M];
				color = board[i][j];
				
				if(recursive(i, j, 0)) return "Yes";
			}
		}
		return "No";
	}

	private static boolean recursive(int x, int y, int move) {

		if(x == sx & y == sy && move > 2) return true;
		
		
		for(int d = 0; d < 4; ++d) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if( nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny ]|| board[nx][ny] != color) continue;
			
			visited[nx][ny] = true;			
			if(recursive(nx, ny, move + 1)) return true;
			visited[nx][ny] = false;
			
		}
		
		return false;
	}

}