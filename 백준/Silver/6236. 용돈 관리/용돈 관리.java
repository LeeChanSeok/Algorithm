import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] money;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		money = new int[N+1];
		for(int i = 1; i <= N; ++i) money[i] = Integer.parseInt(br.readLine());
		
		solution();
	}

	private static void solution() {

		int l = money[1], r = 1000000000, ans = 0;
		for(int i = 2; i <= N; ++i) l = Math.max(l, money[i]);
		
		while(l <= r) {
			int mid = (l + r) / 2;
			
			if(determination(mid)) {
				ans = mid;
				r = mid - 1;
			}else {
				l = mid + 1;
			}
		}
		
		System.out.println(ans);
		
	}

	private static boolean determination(int K) {

		int sum = K;
		int cnt = 1;
		
		for(int i = 1; i <= N; ++i) {
			if(sum < money[i]) {
				++cnt;
				sum = K - money[i];
			}else {
				sum -= money[i];
			}
		}
		
		return cnt <= M;
		
	}

}