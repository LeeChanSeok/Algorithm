import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int[][] map;
	static int r1, r2;
	static final int[][][] DIR = { { { 0, -1, 0, 1 }, { 1, 0, -1, 0 } }, { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				r1 = i;
				r2 = i + 1;
				break;
			}
		}

		System.out.println(dustCnt(solution(map)));

	}

	private static int[][] solution(int[][] map) {

		int[][] newMap;

		int dir;
		int x, y, nx, ny;
		int dust, cnt;
		// 주어신 시간동안 아래의 작업을 반복한다
		for (int t = 0; t < T; t++) {
			newMap = new int[R][C];
			newMap[r1][0] = newMap[r2][0] = -1;
			// 1. 미세먼지가 확산된다.
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] > 0) {
						cnt = 0;
						dust = map[i][j] / 5;
						for (int d = 0; d < 4; d++) {
							nx = i + DIR[0][0][d];
							ny = j + DIR[0][1][d];
	 
							if(!inRange(nx, ny, newMap)) continue;
							newMap[nx][ny] += dust;
							cnt++;
						}
						newMap[i][j] += map[i][j] - dust * cnt;						
					}
				}
			}
			
			
			// 2-1. 위족 공기청정기 작도.
			x = r1-1; y = 0;
			newMap[x][y] = 0;
			dir = 3;
			while (true) {
				// 현재 위치에 모래가 있다면								
				nx = x - DIR[0][0][dir];
				ny = y - DIR[0][1][dir];

				if (!inRange(nx, ny, newMap) || nx > r1) {
					if(--dir == -1) break;
					nx = x - DIR[0][0][dir];
					ny = y - DIR[0][1][dir];
				}
				
				newMap[x][y] = newMap[nx][ny];
				x = nx; y = ny;

			}	// 위쪽 공기 청정기 작동 완료
			newMap[r1][1] = 0;
			// 2-1. 위족 공기청정기 작도.
			x = r2+1; y = 0;
			newMap[x][y] = 0;
			dir = 3;
			while (true) {
				// 현재 위치에 모래가 있다면								
				nx = x - DIR[1][0][dir];
				ny = y - DIR[1][1][dir];

				if (!inRange(nx, ny, newMap) || nx < r2) {
					if(--dir == -1) break;
					nx = x - DIR[1][0][dir];
					ny = y - DIR[1][1][dir];
				}
				
				newMap[x][y] = newMap[nx][ny];
				x = nx; y = ny;

			}	// 위쪽 공기 청정기 작동 완료	
			newMap[r2][1] = 0;
			arrCopy(newMap, map);
			

		}// 시간 종료

		return map;

	}

	private static void arrCopy(int[][] from, int[][] to) {
		
		for(int i = 0 ; i < R; i++)
			to[i] = from[i].clone();
	}
	
	private static boolean inRange(int x, int y, int[][] map) {
		if (x < 0 || 
				x >= R || 
				y < 0 || 
				y >= C 
				|| map[x][y] == -1)
			return false;
		return true;
	}

	private static int dustCnt(int[][] map) {
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				res += map[i][j];
			}
		}

		return res + 2;
	}

}