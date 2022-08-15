import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, max;
	public static int[] input, pick;

	public static int calc_Max() {
		int res = 0;
		for(int i = 0; i < N-1; i++)
			res += Math.abs(pick[i] - pick[i+1]);
		
		return res;
	}
	
	public static void perm(int cnt, int flag) {
		if(cnt == N) {
			max = Math.max(max, calc_Max());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 <<i) != 0) continue;
			pick[cnt] = input[i];
			perm(cnt + 1, flag | 1 <<i);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		pick = new int[N];
		max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		perm(0, 0);
		System.out.println(max);
	}
}