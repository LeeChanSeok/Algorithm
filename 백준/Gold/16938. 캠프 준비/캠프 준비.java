import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int answer;
	static int N, L, R, X;
	static int[] level, subSum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		level = new int[N];
		subSum = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			level[i] = Integer.parseInt(st.nextToken());
        }
		
		Arrays.sort(level);
		
		solution(0, Integer.MAX_VALUE-1, 0, 0);
		System.out.println(answer);
	}
	private static void solution(int idx, int min, int max, int sum) {
		
		if(sum > R) return;
		
		if(idx == N) {
			if(sum >= L && Math.abs(max-min) >= X) ++answer;
			return;
		}
		
		int lev = level[idx];

		solution(idx+1, Math.min(min, lev), Math.max(max, lev), sum + lev);
		solution(idx+1, min, max, sum);
				
	}

}
