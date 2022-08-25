import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, max, home;
	static char[][] map;
	static int[] fee;
	
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	
	private static void initFee() {
		fee = new int[23];
		for(int i = 1, kSize = fee.length; i < kSize; i++) {
			fee[i] = i*i + (i-1)*(i-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		initFee();
		
		int T = Integer.parseInt(br.readLine());
//		T=1;
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][N];
			home = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if(map[i][j]=='1') home++;
					
				}
			}
			
			max = 1;
			int kMax = (N % 2== 0) ? N+1: N;
			for(int k = 2; k <= kMax; k++) {
				max = Math.max(max, simulation(k));
				if(max == home) break;
			}
			sb.append("#" + tc + " " + max +"\n");
			
		}//tc 종료
		
		bw.write(sb.toString());
		bw.close();

	}

	private static int simulation(int K) {

		int maxHome = Math.min(fee[K], home);
		if(M * maxHome - fee[K] < 0) return -1;
		
		int maxCnt = 0;
		int hCnt;
		
		int b = (K-1) / 2; b= 0;
		// 방범 범위의 중앙위치
		for(int i = b; i < N - b; i++) {
			for(int j = b; j< N - b; j++) {
				//현재 위치에서 포함할 수 있는 집의 수
				
				hCnt = 0;
				if(map[i][j] == '1') hCnt++;
				// k 범위 만큼
				for(int k = 1; k < K; k++) {
					//4방향
					int dir = 0;
					int nx = i-k, ny = j;
					for(int l = 1; l <= k*4; l++) {
						nx += dx[dir];
						ny += dy[dir];
						
						if(l % k == 0) dir++;
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if(map[nx][ny] == '1') hCnt++;
					}
					
				}
				
				maxCnt = Math.max(maxCnt, hCnt);
				if (maxHome == maxCnt) return maxHome;
				
			}
		}
		int pay = M * maxCnt - fee[K];
		
		if(pay < 0) return -1;
		return maxCnt;
	}

}
