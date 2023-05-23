import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] board;
	static boolean[][] fallArr;
	
	static int N, M, R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		fallArr = new boolean[N][M];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Map<Character, Integer> dirMap = new HashMap<>();
		dirMap.put('E', 0); 
		dirMap.put('W', 1);
		dirMap.put('S', 2);
		dirMap.put('N', 3);
		
		int answer = 0;
		int x, y, dir;
		for(int r = 0; r < R; ++r) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			dir = dirMap.get(st.nextToken().charAt(0));
			
			// 1. 공격
			if(!fallArr[x][y])
				answer += fall_domino(x, y, dir);
			
			// 2. 수비
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			fallArr[x][y] = false;
		}
		
		sb.append(answer+"\n");
		char c;
		for(int i = 0; i < N; ++i) {

			for(int j = 0; j < M; ++j) {
				c = (fallArr[i][j]) ? 'F' : 'S';
				sb.append(c + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

	private static int fall_domino(int x, int y, int dir) {
		
		int fallCnt = 0;
		
		int length = board[x][y];
		
		int cx = x, cy = y;
		int ex = x + dx[dir] * (length), ey = y + dy[dir] * (length);
		
		int nx, ny;
		while(true) {
			if(cx == ex && cy == ey) break;
			
			if(!fallArr[cx][cy]) {
				fallArr[cx][cy] = true;
				++fallCnt;
				
				length = board[cx][cy];
				nx = cx + dx[dir] * (length);
				ny = cy + dy[dir] * (length);
				
				// 증가하는 방향
				if((dir & 1) == 0) {
					ex = Math.max(ex, nx);
					ex = Math.min(ex, N);
					
					ey = Math.max(ey, ny);
					ey = Math.min(ey, M);
				}else {
					ex = Math.min(ex, nx);
					ex = Math.max(ex, -1);
					
					ey = Math.min(ey, ny);
					ey = Math.max(ey, -1);
				}
			}
			
			cx += dx[dir];
			cy += dy[dir];
			
		}
		
		
		return fallCnt;
	}

}
