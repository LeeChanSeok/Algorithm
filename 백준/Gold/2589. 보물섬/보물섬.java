import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static char[][] board;
	static boolean[][] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		int answer = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == 'L') {
					int time = bfs(i, j)-1;
					answer = Math.max(answer, time);
				}
			}
		}
		System.out.println(answer);

	}
	private static int bfs(int i, int j) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		boolean[][] visited = new boolean[N][M];
		visited[i][j] = true;
		
		int qSize;
		int time = 0;
		int[] cur = new int[3];
		int nx, ny;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				
				for(int d = 0; d < 4; ++d) {
					nx = cur[0] + dx[d];
					ny = cur[1] + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || board[nx][ny] =='W') continue;
					
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
				
			}
			++time;
		}

		return time;
	}

}