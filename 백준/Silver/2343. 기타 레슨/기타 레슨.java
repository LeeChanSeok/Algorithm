import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] lectures;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lectures = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) lectures[i] = Integer.parseInt(st.nextToken());
		
		solution();
		
	}

	private static void solution() {
		
		int l = lectures[1], r = Integer.MAX_VALUE/2, ans = 0;
		for(int i = 2; i<= N; ++i) l = Math.max(l, lectures[i]);
		
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

	private static boolean determination(int len) {

		int cnt = 1, sum = 0;
		for(int i =1; i <= N; ++i) {
			
			if(sum + lectures[i] > len) {
				sum = lectures[i];
				++cnt;
			}
			else {
				sum += lectures[i];
			}
			
		}
		
		return cnt <= M;
	}

}