import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, K;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] stack = new int[N];
		
		int s, e;
		for(int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			
			s = Integer.parseInt(st.nextToken()) - 1;
			e = Integer.parseInt(st.nextToken()) - 1;
			
			++stack[s];
			if(e == N - 1) continue;
			--stack[e+1];
		}

		for(int i = 1; i < N; ++i)
			stack[i] += stack[i-1];

		Arrays.sort(stack);
		System.out.println(stack[N/2]);

	}

}