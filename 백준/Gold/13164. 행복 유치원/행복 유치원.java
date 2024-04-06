import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n-1];
		st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int i = 1; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());				
			int diff = num - prev;
			arr[i-1] = diff;
			sum += diff;			
			
			prev = num;
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < k - 1; ++i) {
			sum -= arr[n-2-i];
		}
		
		System.out.println(sum);

	}

}