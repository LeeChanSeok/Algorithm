import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[n+1][m+1];
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; ++j) {
				A[i][j] = A[i-1][j] + A[i][j-1] + Integer.parseInt(st.nextToken()) - A[i-1][j-1];
			}
		}

		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(A[x2][y2] - A[x2][y1-1] - A[x1-1][y2] + A[x1-1][y1-1]).append('\n');
		}
		System.out.println(sb);
	}

}