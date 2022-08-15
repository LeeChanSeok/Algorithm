import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int max;
	public static int[] T, P;
	
	public static void combination(int pIdx, int cIdx, int sum) {
		if(cIdx > N) {
			max = Math.max(max, sum - P[pIdx]);
			return;
		}else if(cIdx == N) {
			max = Math.max(max, sum);
		}
		
		for(int i = cIdx; i < N; i++) {
			combination(i, i + T[i], sum + P[i]);
			combination(i, i + 1, sum);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		combination(0, 0, 0);
		System.out.println(max);
	}

}