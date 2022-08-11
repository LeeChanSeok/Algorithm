import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int min;
	public static void combination(int[][] ingredient, int N, int cnt, int S, int B) {
		
		if(cnt == N) {
			if(S == 1 && B == 0) return;
			min = Math.min(min, Math.abs(S - B));
			return;
		}
		combination(ingredient, N, cnt + 1, S * ingredient[cnt][0], B + ingredient[cnt][1]);
		combination(ingredient, N, cnt + 1, S, B);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] ingredient = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		combination(ingredient, N, 0, 1, 0);
		System.out.println(min);
		
	}
}