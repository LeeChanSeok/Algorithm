import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, min, start;
	public static int[][] W;
	
	public static void permutation(int cnt, int flag, int s, int sum) {
		if(sum >= min) return;
		if(cnt == N) {
			if(W[s][start] == 0) return;
			min = Math.min(min, sum + W[s][start]);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 <<i) != 0) continue;
			if(W[s][i] == 0) continue;
			permutation(cnt +1, flag | 1 << i, i, sum + W[s][i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			start = i;
			permutation(1, 1 << i, i, 0);
		}
			
		System.out.println(min);
	}

}