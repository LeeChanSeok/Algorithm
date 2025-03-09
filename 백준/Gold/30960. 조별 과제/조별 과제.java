import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int[][] D = new int[N+1][2];
		
		int INF = (int)1e9;
		D[1][0] = INF;
		D[1][1] = INF;
		for(int i = 2; i <= N; i++) {
			if(i % 2 == 0) {
				D[i][0] = D[i-2][0] + A[i] - A[i-1];
				D[i][1] = INF;
			} else {
				D[i][0] = D[i-2][0] + A[i] - A[i-1];
				D[i][1] = Math.min(D[i-2][1] + A[i] - A[i-1], D[i-3][0] + A[i] - A[i-2]);
			}
		}
		
		System.out.println(D[N][1]);

	}

}