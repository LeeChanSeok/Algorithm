import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] sum = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + num;
		}

		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			sb.append(sum[q] - sum[p - 1]).append('\n');
		}
		
		System.out.println(sb);
	}

}