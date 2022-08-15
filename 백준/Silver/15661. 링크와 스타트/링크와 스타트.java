import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, R;
	public static int total_score, min;
	public static int[][] ability;
	public static int[] s;

	public static void 	combination(int idx, int cnt, int flag) {
		
		if(cnt == R) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if((flag & 1 <<i) != 0) 
					sum += s[i]; 
			}
			
			min = Math.min(min, Math.abs(total_score - sum));
			return;
		}
		
		for(int i = idx; i < N; i++) {
			combination(i + 1, cnt + 1, flag | 1 <<i );
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];
		total_score = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
				total_score += ability[i][j];
			}
		}
		s = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				s[i] += ability[i][j] + ability[j][i];
			}
		}

		min = Integer.MAX_VALUE;
		for (int r = 1; r <= N / 2; r++) {
			R = r;
			combination(0, 0, 0);
		}
		System.out.println(min);
	}
}