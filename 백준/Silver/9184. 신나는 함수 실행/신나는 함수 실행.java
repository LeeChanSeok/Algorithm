import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = 20;
		int[][][] W = new int[n + 1][n + 1][n + 1];
		for(int a = 0; a <= n; a++) {
			
			for(int b = 0; b <= n; b++) {
				
				for(int c = 0; c <= n; c++) {
					
					if(a == 0 || b == 0 || c == 0) W[a][b][c] = 1;
					else if(a < b && b < c) {
						W[a][b][c] = W[a][b][c-1] + W[a][b-1][c-1] - W[a][b-1][c];
					}else {
						W[a][b][c] = W[a-1][b][c] + W[a-1][b-1][c] + W[a-1][b][c-1] - W[a-1][b-1][c-1];
					}
					
				}
				
			}
			
		}

		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) break;
			
			int ans = 0;
			if(a <= 0 || b <= 0 || c <= 0) ans = 1;
			else if(a > 20 || b > 20 || c > 20) ans = W[20][20][20];
			else ans = W[a][b][c];
			
			sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, ans));
			
		}

		System.out.println(sb);
	}

}