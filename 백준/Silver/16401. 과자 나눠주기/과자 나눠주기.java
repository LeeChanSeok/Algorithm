import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		int ans = binarySearch(arr, M, N);
		System.out.println(ans);

	}

	private static int binarySearch(int[] arr, int m, int n) {

		int l = 1;
		int r = arr[n - 1];
		
		int res = 0;
		while(l <= r) {
			int mid = (l + r) / 2;
			
			int cnt = 0;
			for(int i = n - 1; i >= 0; --i) {
				cnt += (arr[i] / mid);
				if(cnt >= m) break;
			}
			
			if(cnt >= m) {
				res = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		
		return res;
	}

}