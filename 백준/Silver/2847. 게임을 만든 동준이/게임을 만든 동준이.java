import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i = n-1; i >= 0; --i) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0;
		for(int i = 1; i < n; ++i) {
			
			if(arr[i] < arr[i - 1]) continue;
			
			ans += (arr[i] - arr[i-1] + 1);
			arr[i] = arr[i-1] - 1;
		}
		
		System.out.println(ans);
		
	}

}