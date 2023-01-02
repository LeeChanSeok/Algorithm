import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int delta = 100;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] board = new char[N][N];
		int[][] island = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		
		List<List<Integer>> islands = new ArrayList<>();
		islands.add(null);
		
		int group = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(island[i][j] == 0 && board[i][j] == '1') {
					++group;
					islands.add(new LinkedList<>());
					makeGroup(N, group, i, j, island, board, islands);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= group; ++i) {
			min = Math.min(min, findShortPath(N, i, island, islands));
		}
		
		
		System.out.println(min);
	}

	private static int findShortPath(int N, int i, int[][] island, List<List<Integer>> islands) {

		Queue<Integer> q = new LinkedList<>(islands.get(i));
		boolean[][] visit = new boolean[N][N];
		
		int cnt = 0;
		int qSize, cur, x, y, nx, ny;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				x = cur/delta; y = cur%delta;
				for(int d = 0; d < 4; ++d) {
					nx = x + dx[d];
					ny = y + dy[d];
				
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || island[nx][ny] == i || visit[nx][ny]) continue;
					
					if(island[nx][ny] != 0) return cnt;
					visit[nx][ny] = true;
					q.offer(nx*delta + ny);
				}
			}
			
			++cnt;
		}
		
		return -1;
		
	}

	private static void makeGroup(int N, int group, int x, int y, int[][] island, char[][] board, List<List<Integer>> islands) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(x*delta + y);
		island[x][y] = group;
		islands.get(group).add(x*delta + y);
		
		int nx, ny, cur, next;
		while(!q.isEmpty()) {
			cur = q.poll();
			x = cur/delta; y = cur %delta;
			
			for(int d = 0; d < 4; ++d) {
				nx = x + dx[d]; ny = y + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == '0' || island[nx][ny] != 0) continue;
				
				next = nx*delta + ny;
				island[nx][ny] = group;
				islands.get(group).add(next);
				q.offer(next);
			}
		}
	}

}