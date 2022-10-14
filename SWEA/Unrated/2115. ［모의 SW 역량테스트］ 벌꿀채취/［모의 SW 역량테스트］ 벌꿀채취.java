import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution
{
	static int N, M, C, scoreSize, max;
	static int[][] board, score;
	static Integer[] maxRow;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			scoreSize = N - M + 1;
			score = new int[N][scoreSize];
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < scoreSize; ++j) {
					max = 0;
					getMaxScore(i, j, 0, 0, 0);
					score[i][j] = max;
				}
			}
			
			maxRow = new Integer[N];
			// 1. 다른 행에서 고르는경우
			for(int i = 0; i < N; ++i) {
				maxRow[i] = getMaxNum(score[i], scoreSize);
			}
			
			Arrays.sort(maxRow, Collections.reverseOrder());
			max = maxRow[0] + maxRow[1];

			// 2. 같은 행에서 고르는 경우
			int sum;
			for(int i = 0; i < N; ++i) {
				sum = 0;
				for(int j = 0; j < scoreSize - M; ++j) {
					max = Math.max(max, score[i][j] + score[i][j+M]);
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
	
	private static int getMaxNum(int[] sc, int scoreSize) {
		int max = sc[0];
		for(int i = 1; i < scoreSize; ++i)
			max = Math.max(max, sc[i]);
		return max;
	}
	
	private static void getMaxScore(int x, int y, int cnt, int total, int score) {
		
		if(total > C) return;
		
		if(cnt == M) {
			max = Math.max(max, score);
			return;
		}
		
		int num = board[x][y];
		getMaxScore(x, y+1, cnt+1, total, score);
		getMaxScore(x, y+1, cnt+1, total + num, score + num * num);
		
	}
}