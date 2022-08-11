import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int max;
	
	public static void combination(int[][] ingredient, int N, int L, int cnt, int score, int cal) {
		if(cal > L) return;
		if(cnt == N) {
			max = Math.max(max, score);
			return;
		}
		combination(ingredient, N, L, cnt+1, score, cal);
		combination(ingredient, N, L, cnt+1, score + ingredient[cnt][0], cal + ingredient[cnt][1]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T;
		int N, L;
		int[][] ingredient;
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			ingredient = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			combination(ingredient, N, L, 0, 0, 0);
			System.out.printf("#%d %d\n",tc, max);
			
		} // test-case 종료

	}

}