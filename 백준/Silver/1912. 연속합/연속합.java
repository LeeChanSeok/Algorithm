import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		int ans = arr[0];
		int subSum = arr[0];
		for(int i = 1; i < n; ++i) {
			if(subSum + arr[i] >= 0) {
				subSum += arr[i];
				ans = Math.max(ans, subSum);
			}else {
				subSum = 0;
				ans = Math.max(ans, arr[i]);
			}
		}
		
		System.out.println(ans);

	}

}