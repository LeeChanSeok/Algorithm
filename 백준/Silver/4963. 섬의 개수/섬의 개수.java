import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int MAX_W = 50;
	static final int MAX_H = 50;
	static final int DELTA = 100;
	
	static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static boolean[][] board = new boolean[MAX_H][MAX_W];
	static boolean[][] visited = new boolean[MAX_H][MAX_W];
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int answer;
	static int w, h;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0) break;
			
			init();
			
			for(int i = 0; i < h; ++i) {
				for(int j = 0; j < w; ++j) {
					if(visited[i][j] || !board[i][j]) continue;
					bfs(i, j);
					++answer;
				}
			}
			sb.append(answer + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
	
	private static void bfs(int i, int j) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(i*DELTA + j);
		visited[i][j] = true;
		
		int cur, x, y, nx, ny;
		while(!q.isEmpty()) {
			cur = q.poll();
			x = cur/DELTA;
			y = cur%DELTA;
			
			for(int d = 0; d < 8; ++d) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if(!inRange(nx, ny) || !board[nx][ny] || visited[nx][ny]) continue;
				
				q.offer(nx * DELTA + ny);
				visited[nx][ny] = true;
			}
			
		}
		
	}

	private static boolean inRange(int x, int y) {
		if(x >= 0 && x < h && y >= 0 && y < w) return true;
		return false;
	}

	public static void init() throws IOException {
		//board 초기화
		for(int i = 0; i < h; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; ++j) {
				board[i][j] = (st.nextToken().charAt(0) == '0') ? false : true;
			}
		}
		
		// visited 초기화
		for(int i = 0; i < MAX_H; ++i) {
			Arrays.fill(visited[i], false);
		}
		
		answer = 0;
	}

}