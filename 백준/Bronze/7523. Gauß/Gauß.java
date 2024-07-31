import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; ++i) {
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());
			
			long sumM = m * (m + 1) / 2;
			long sumN = n * (n - 1) / 2;
			
			System.out.printf("Scenario #%d:\n%d\n\n",i, sumM- sumN);
		}

	}

}