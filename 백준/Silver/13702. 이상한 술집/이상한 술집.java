import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] mak;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		mak = new int[N+1];
		for(int i = 1; i <= N; ++i) mak[i] = Integer.parseInt(br.readLine());
		
		solution();
	}

	private static void solution() {

		long l = 1, r = Integer.MAX_VALUE, ans = 0;
		
		
		while(l <= r) {
			long mid = (l + r) / 2;
			
			if(determination(mid)) {
				ans = mid;
				l = mid + 1;
			}else {
				r = mid - 1;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean determination(long volume) {
		if(volume == 0) return false;
		
		long sum = 0;
		
		for(int i = 1; i <= N; ++i) {
			sum += mak[i] / volume;
			if(sum >= K) return true;
		}
		
		return false;
	}

}