import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int max = 1000001;
		int[] zeroCnt = new int[max];
		
		zeroCnt[0] = 1;
		for(int i = 1; i < max; ++i) {
			int num = i;
			while(num != 0) {
				if(num % 10 == 0) ++zeroCnt[i];
				num /= 10;
			}
		}
		
		for(int i = 1; i < max; ++i) {
			zeroCnt[i] += zeroCnt[i-1];
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int res = 0;
			if(n == 0) res = zeroCnt[m];
			else {
				res = zeroCnt[m] - zeroCnt[n-1];
			}
			
			sb.append(res).append('\n');
		}

		System.out.println(sb);
	}

}