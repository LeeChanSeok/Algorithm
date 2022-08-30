import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static final int N = 8;
	static int M;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			M = Integer.parseInt(br.readLine());
			
			arr = new char[N][N];
			
			for(int i = 0; i < N; i++)
				arr[i] = br.readLine().toCharArray();
			
			System.out.println("#" + tc + " " + solution());
		}

	}
	private static int solution() {
		int ans = 0;
		
		// 행 검사
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - M + 1 ; j++) {
				if(isPalindromeRow(i, j)) ans++;
			}
		}
		
		// 열 검사
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < N - M + 1 ; i++) {
				if(isPalindromeCol(j, i)) ans++;
			}
		}
		
		
		
		return ans;
	}
	private static boolean isPalindromeRow(int row, int start) {
		
		for(int j = 0; j < M/2; j++) {
			if(arr[row][start+j] != arr[row][start + M - j - 1]) return false;
		}
		
		return true;
	}

	private static boolean isPalindromeCol(int col, int start) {
		
		for(int i = 0; i < M/2; i++) {
			if(arr[start+i][col] != arr[start + M - i - 1][col]) return false;
		}
		
		return true;
	}
}