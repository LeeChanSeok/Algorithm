import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		long[] A_sum = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) A_sum[i] = A_sum[i-1] + Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		long[] B_sum = new long[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; ++i) B_sum[i] = B_sum[i-1] + Integer.parseInt(st.nextToken());

		long cnt;
		long sum;
		Map<Long, Long> B_map = new HashMap<>();
		for(int i = 1; i <= M; ++i) {
			for(int j = i; j <= M; ++j) {
				sum = B_sum[j] - B_sum[i-1];
				cnt = B_map.getOrDefault(sum, 0l)+1;
				B_map.put(sum, cnt);
			}
		}

		long answer = 0;
		for(int i = 1; i <= N; ++i) {
			for(int j = i; j <= N; ++j) {
				sum = A_sum[j] - A_sum[i-1];
				cnt = B_map.getOrDefault(T-sum, 0l);
				answer += cnt;
			}
		}
		
		System.out.println(answer);
	}

}