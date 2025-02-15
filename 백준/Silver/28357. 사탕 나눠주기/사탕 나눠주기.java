import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long K;
	static long[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(binarySearch());
	}

	private static long binarySearch() {

		
		long l = 0, r = (long)1e12;
		long res = r;
		
		while(l <= r) {
			long mid = (l + r) / 2;
			
			if(solution(mid)) {
				res = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
			
		}
		
		return res;
	}

	private static boolean solution(long x) {

		long cnt = 0;
		for(int i = N - 1; i >= 0; --i) {
			if(arr[i] <= x) break;
			cnt += (arr[i] - x);
		}
		
		if(cnt > K) return false;
		return true;
	}

}