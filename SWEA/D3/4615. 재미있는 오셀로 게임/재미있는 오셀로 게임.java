import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static final int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N, M;
		int[] cnt;
		int[][] command, arr;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			command = new int[M][3];
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				
				command[i][0] = Integer.parseInt(st.nextToken()) -1;
				command[i][1] = Integer.parseInt(st.nextToken()) -1;
				command[i][2] = Integer.parseInt(st.nextToken());
				
			}
			
			arr[N/2-1][N/2-1] = arr[N/2][N/2] = 2;
			arr[N/2-1][N/2] = arr[N/2][N/2-1] = 1;
			
			cnt = new int[3];
			cnt[1] = cnt[2] = 2;
			for(int i = 0; i < M; ++i) {
				getStone(N, M, i, command, arr, cnt);
			}
					
			System.out.printf("#%d %d %d\n", tc, cnt[1], cnt[2]);
			
		}// tc 종료
	}

	private static void getStone(int N, int M, int idx, int[][] command, int[][] arr, int[] cnt) {
		int x, y, c;
		int nx, ny;
		x = command[idx][0];
		y = command[idx][1];
		c = command[idx][2];
		
		++cnt[c];
		arr[x][y] = c;
		boolean isGet = false;
		// 상, 하, 좌, 우, 대각선에 잡을 수 있는 돌이 있는지 확인
		for(int d = 0; d < 8; ++d) {
			nx = x; ny = y;
			isGet = false;
			while(true) {
				nx += dx[d]; ny+=dy[d];
				if(nx < 0 || nx >=N || ny < 0 || ny >= N
						|| arr[nx][ny] == 0) break;
				
				if(arr[nx][ny] == c) {
					isGet = true;
					break;
				}
			}
			
			if(isGet) {
				nx -= dx[d]; ny -= dy[d];
				while(!(nx == x && ny == y)){
					arr[nx][ny] = c;
					++cnt[c];
					--cnt[(c&1) + 1];
					nx -= dx[d]; ny -=dy[d];
				}
			}
			
		}
		
	}

}
