import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int max = 1_000_000;
		
		long[] arr = new long[max + 1];
		long[] d = new long[max+1];
		init(arr, d, max);
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			sb.append(d[N]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void init(long[] arr, long[] d, long max) {
		Arrays.fill(arr, 1);

		for(int i = 2; i <= max; i++) 
			for(int j = 1; i*j <= max; j++)
				arr[i*j] += i;
		
		for(int i = 1; i <= max; i++) 
			d[i] = d[i-1] + arr[i];
	}

}