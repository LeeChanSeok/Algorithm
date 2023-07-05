import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] nums, check;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) nums[i] = Integer.parseInt(st.nextToken());
		check = new int[100000+1];
		
		solution();

	}
	private static void solution() {
		
		long ans = 0;
		for(int L = 1, R = 0; L <= N; ++L) {
			
			while(R + 1 <= N && check[nums[R+1]] == 0) {
				++R;
				++check[nums[R]];
			}
			
			ans += R - L + 1;
			--check[nums[L]];
			
		}
		
		System.out.println(ans);
		
	}

}