import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] board;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M]; 
	
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}

		int meet = bfs(N, M, find_start(N, M));
		if(meet == 0) System.out.println("TT");
		else System.out.println(meet);
		
	}

	private static int bfs(int N, int M, int[] start) {

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		
		boolean[][] visited = new boolean[N][M];
		visited[start[0]][start[1]] = true;
		
		int meet = 0;
		int nx, ny;
		int[] cur;
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int d = 0; d < 4; ++d) {
				nx = cur[0] + dx[d];
				ny = cur[1] + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || board[nx][ny] == 'X') continue;
				
				if(board[nx][ny] == 'P') ++meet;
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		
		return meet;
	}

	private static int[] find_start(int n, int m) {

		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(board[i][j] == 'I') return new int[]{i, j};
			}
		}
		
		return null;
	}

}