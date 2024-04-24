import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		int l = 0, r = n - 1;
		while(l < r) {
			int sum = arr[l] + arr[r];
			
			if(sum == m) {
				++cnt;
				++l; --r;
			}else if(sum < m) {
				++l;
			} else {
				--r;
			}
		}
		
		System.out.println(cnt);

	}

}