import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int N = 100;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();
			
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j <N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int res = Math.max(sumRow(), sumCol());
			res = Math.max(res, sumdiagonal());
			System.out.println("#" + tc + " " + res);
			
		}
	}
	private static int sumRow() {
		int max = 0;
		for(int i = 0; i < N; i++) {
			int rowSum = 0;
			for(int j = 0; j < N; j++)
				rowSum += map[i][j];
			
			max = Math.max(max, rowSum);

		}
		
		return max;
	}

	private static int sumCol() {
		int max = 0;
		for(int j = 0; j < N; j++) {
			int colSum = 0;
			for(int i = 0; i < N; i++)
				colSum += map[i][j];
			
			max = Math.max(max, colSum);
		}
		
		return max;
	}
	
	private static int sumdiagonal() {
		int diagSum = 0; int undiagSum = 0;
		for(int i = 0; i < N; i++) {
			diagSum += map[i][i];
			undiagSum += map[i][N-i-1];
		}
		
		return Math.max(diagSum, undiagSum);
	}
}