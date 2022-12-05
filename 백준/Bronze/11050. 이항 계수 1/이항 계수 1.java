import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] memory;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		memory = new int[N+1][N+1];
		int ans = bino_coeff(N, K);
		System.out.println(ans);
	
	}

	private static int bino_coeff(int N, int K) {

		if(K  > N/2) K = N - K;
		
		if(memory[N][K] != 0) return memory[N][K];		
		
		if(K == 1) return N;
		if(K == 0) return 1;
		
		memory[N][K] = bino_coeff(N-1, K-1) + bino_coeff(N-1, K);
		
		return memory[N][K];
	}

}