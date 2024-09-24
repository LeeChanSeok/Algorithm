import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] L = new int[N+1];
		int[] R = new int[N+1];
		
		for(int i = 1; i <= N; ++i) {
			L[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= N; ++i) {
			R[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] D = new int[N+1][N+1];
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
				if(Math.abs(L[i] - R[j]) <= 4) {
					D[i][j] = D[i-1][j-1] + 1;
				}
			}
		}
		
		System.out.println(D[N][N]);

	}

}