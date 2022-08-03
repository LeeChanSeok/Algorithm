import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/com/swea/D2/N2001/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int res = 0;
			int i_res = 0;
			for(int i = 0; i < N-M+1; i++) {
				if(i == 0) {
					for(int r = 0; r < M; r++)
						for(int c = 0; c < M; c++)
							i_res += arr[r][c];
							
				}else {
					for(int c = 0; c < M; c++) {
						i_res -= arr[i-1][c];
						i_res += arr[i+M-1][c];
					}
					
				}
				max = Math.max(max, i_res);
				res = i_res;
				for(int j = 1; j < N-M+1; j++) {
					for(int r = i; r < i + M; r++) {
						res -= arr[r][j-1];
						res += arr[r][j+M-1];
					}
					max = Math.max(max, res);
				}
			}
			
			System.out.printf("#%d %d\n",tc, max);
		}
		
		
		
	}

}