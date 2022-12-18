import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] board = new char[N][N];
		
		for(int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		
		List<Integer> cntlist = new LinkedList<>();
		int group = 0;
		boolean[][] visit = new boolean[N][N];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(board[i][j] == '0' || visit[i][j]) continue;
				++group;
				cntlist.add(bfs(i, j, N, board, visit));
			}
		}
		System.out.println(group);

		Collections.sort(cntlist);
		for(int cnt : cntlist) {
			System.out.println(cnt);
		}

	}

	private static int bfs(int i, int j, int N, char[][] board, boolean[][] visit) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		int cnt = 1;
		char num = board[i][j];
		int[] cur;
		int x, y, nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			x = cur[0]; y = cur[1];
			
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || board[nx][ny] != num) continue;
				
				q.offer(new int[] {nx, ny});
				visit[nx][ny] = true;
				++cnt;
			}
		}
		
		return cnt;
	}

}