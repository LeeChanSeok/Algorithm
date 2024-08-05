import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long ans = Long.MAX_VALUE;
		Arrays.sort(arr);
		for(int i = 1; i < N; ++i) {
			long v1 = (long)arr[0] * i;
			long v2 = (long)arr[i] * (N - i);
			
			long v = v1 + v2;
			long time = K / v;
			if(K % v != 0) ++time;
			
			ans = Math.min(ans, time);
			
		}
		
		System.out.println(ans);
	}

}