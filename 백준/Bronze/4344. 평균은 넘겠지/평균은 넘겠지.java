import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int C = Integer.parseInt(br.readLine());
		while(C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] num = new int[N];
			
			int sum = 0;
			for(int i = 0; i < N; ++i) {
				num[i] = Integer.parseInt(st.nextToken());
				sum += num[i];
			}
			
			double avg = sum / (double)N;
			
			int cnt = 0;
			for(int i = 0; i < N; ++i) {
				if(num[i] > avg) ++cnt;
			}
			
			System.out.printf("%.3f%%\n", Math.round(cnt * 100.0 * 1000/N)/1000.0);
		}

	}

}