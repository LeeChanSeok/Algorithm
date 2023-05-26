import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int DELTA = 100;
	static char[][] board;
	static int[] start;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i = 0; i < R; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		

		start = new int[3];
		int x, y;
		for(int i = 0; i < 3; ++i) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken()) -1;
			y = Integer.parseInt(st.nextToken()) -1;
			
			start[i] = x * DELTA + y;
		}
		
		System.out.println(solution(R, C));
		
	}

	private static String solution(int r, int c) {

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		
		Queue<Integer>[] devil = new LinkedList[3];
		for(int i = 0; i < 3; ++i) devil[i] = new LinkedList<>();
		
		
		int[][][] visited = new int[3][r][c];
		for(int k = 0; k < 3; ++k) {
			for(int i = 0; i < r; ++i) {
				Arrays.fill(visited[k][i], -1);
			}
		}
		
		int x, y, nx, ny;
		int cur;
		int qSize;
		Queue<Integer> q;
		for(int k = 0; k < 3; ++k) {
			
			q = devil[k];
			x = start[k]/DELTA; 
			y = start[k]%DELTA;
			visited[k][x][y] = 0;
			q.offer(start[k]);
			
			while(!q.isEmpty()) {
				
				qSize = q.size();
				while(qSize-- > 0) {
					cur = q.poll();
					
					x = cur / DELTA; y = cur % DELTA;
					
					for(int d = 0; d < 4; ++d) {
						
						nx = x + dx[d];
						ny = y + dy[d];
						
						if(nx < 0 || nx >= r || ny < 0 || ny >=c || board[nx][ny] == '1' || visited[k][nx][ny] != -1 ) continue;
						
						visited[k][nx][ny] = visited[k][x][y] + 1;
						q.offer(nx * DELTA + ny);
					}
				}
			
			}
			
		}
		
		int INF = Integer.MAX_VALUE;
		int[][] dist = new int[r][c];
		for(int i = 0; i < r; ++i) {
			for(int j = 0; j < c; ++j) {
				if(visited[0][i][j] == -1 || visited[1][i][j] == -1 || visited[2][i][j] == -1) dist[i][j] = INF;
				else {
					dist[i][j] = Math.max(visited[0][i][j], Math.max(visited[1][i][j], visited[2][i][j]));
				}
				
			}
		}
		
		int[] answer = {INF, 0};
		for(int i = 0; i < r; ++i) {
			for(int j = 0; j < c; ++j) {
				if(dist[i][j] < answer[0]) {
					answer[0] = dist[i][j];
					answer[1] = 1;
				}else if(dist[i][j] == answer[0]) {
					++answer[1];
				}
			}
		}
		
		if(answer[0] == INF) return "-1";
		else return answer[0] + "\n" + answer[1];
		
	}

}