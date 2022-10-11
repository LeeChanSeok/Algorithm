import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N, X;
	static int ans;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			ans = solution(N, X, board);
			System.out.printf("#%d %d\n", tc, ans);
		} // test-case 종료

	}

	private static int solution(int N, int X, int[][] board) {
		boolean[][][] build = new boolean[N][N][2];
		
		int ans = 0;
		int k, h, cnt;
		boolean isBuild;
		// 행
		
		for(int i = 0; i < N; ++i) {
			isBuild = true;
			h = board[i][0];
			
			for(int j = 1; j < N; ++j) {
				if(board[i][j] == h) continue;
				
				// 높아지는 경우
				else if(board[i][j] > h) {
					// 높이 차가 2 이상인 경우
					if(board[i][j] - h > 1) {
						isBuild = false; 
						break;
					}
					
					k = j - 1;
					cnt = 0;
					// j-1부터 뒤쪽에 L개의 동일 높이의 땅이 있는지 확인
					while(k >= 0 && board[i][k] == h && !build[i][k][0]) {
						++cnt;
						--k;
					}
					
					if(cnt < X) {
						isBuild = false;
						break;
					}
					
					// 경사로 설치
					for(k = j - X; k < j; ++k) build[i][k][0] = true;
					h = board[i][j];
				}
				
				// 낮아지는 경우
				else if(board[i][j] < h) {
					// 높이 차가 2 이상인 경우
					if(h - board[i][j] > 1) {
						isBuild = false; 
						break;
					}
					k = j;
					cnt = 0;
					// j부터 뒤쪽에 L개의 동일 높이의 땅이 있는지 확인
					while(k < N && board[i][k] == h-1 && !build[i][k][0]) {
						++cnt;
						++k;
					}
					
					if(cnt < X) {
						isBuild = false;
						break;
					}
					
					// 경사로 설치
					for(k = j; k < j + X; ++k) build[i][k][0] = true;
					h = board[i][j];
				}
			}
			
			if(isBuild) ++ans;
		}
		
		// 열
		for(int j = 0; j < N; ++j) {
			isBuild = true;
			h = board[0][j];
			
			for(int i = 1; i < N; ++i) {
				if(board[i][j] == h) continue;
				
				// 높아지는 경우
				else if(board[i][j] > h) {
					// 높이 차가 2 이상인 경우
					if(board[i][j] - h > 1) {
						isBuild = false; 
						break;
					}
					
					k = i - 1;
					cnt = 0;
					// i-1부터 뒤쪽에 L개의 동일 높이의 땅이 있는지 확인
					while(k >= 0 && board[k][j] == h && !build[k][j][1]) {
						++cnt;
						--k;
					}
					
					if(cnt < X) {
						isBuild = false;
						break;
					}
					
					// 경사로 설치
					for(k = i - X; k < i; ++k) build[k][j][1] = true;
					h = board[i][j];
				}
				
				// 낮아지는 경우
				else if(board[i][j] < h) {
					// 높이 차가 2 이상인 경우
					if(h - board[i][j] > 1) {
						isBuild = false; 
						break;
					}
					k = i;
					cnt = 0;
					// i부터 뒤쪽에 L개의 동일 높이의 땅이 있는지 확인
					while(k < N && board[k][j] == h-1 && !build[k][j][1]) {
						++cnt;
						++k;
					}
					
					if(cnt < X) {
						isBuild = false;
						break;
					}
					
					// 경사로 설치
					for(k = i; k < i + X; ++k) build[k][j][1] = true;
					h = board[i][j];
				}
			}
			
			if(isBuild) ++ans;
		}
		return ans;
	}

}