import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, answer;
	static int[] weight;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weight = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) weight[i] = Integer.parseInt(st.nextToken());
		
		answer = 0;
		recursive(0, 0, 500);
		
		System.out.println(answer);
	}
	private static void recursive(int idx, int flag, int total) {
		if(total < 500) return;
		
		if(idx == N) {
			++answer;
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if((flag & (1 << i)) != 0) continue;
			
			recursive(idx +1, flag | (1 << i), total + weight[i] - K);
		}
		
	}

}