import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[] L, J;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		L = new int[N];
		J = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		recursive(0, 100, 0);
		System.out.println(ans);

	}

	private static void recursive(int idx, int life, int joy) {

		ans = Math.max(ans, joy);
		
		if(idx == N) return;
		
		
		if(life - L[idx] > 0)
			recursive(idx + 1, life - L[idx], joy + J[idx]);
		recursive(idx + 1, life, joy);
		
	}

}