import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, K;
	
	public static void main(String[] args) throws Exception {

		input();
		pro();

	}

	private static void pro() {
		
		long L = 1, R = (long) N * N, answer = 0;
		
		while(L <= R) {
			long mid = (L + R)/2;
			
			if(determination(mid)) {
				R = mid - 1;
				answer = mid;
			}else {
				L = mid + 1;
			}
		}
		
		System.out.println(answer);
		
	}

	private static boolean determination(long candidate) {

		long sum = 0;
		for(int i = 1; i <= N; ++i) {
			sum += Math.min(N, candidate / i);
		}
		return sum >= K;
	}

	private static void input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
	}

}
