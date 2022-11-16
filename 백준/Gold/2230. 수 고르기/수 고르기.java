import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		for(int i = 0; i < N; ++i)
			nums[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(nums);
		
		int ans = nums[N-1] - nums[0], diff, s = 0, e = 1;
		while(s <= e) {
			if(s >= N || e >= N) break;
			
			diff = nums[e] - nums[s];
			if(diff == M) {
				ans = M;
				break;
			}
			else if(diff > M) {
				if (ans > diff) ans = diff;
				++s;
			}else {
				++e;
			}
			
		}

		System.out.println(ans);
	}

}