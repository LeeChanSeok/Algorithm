import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long sec = 1;
		for(int i = 2; i <= N; ++i) {
			sec *= i;
		}
		
		long mod = 7 * 24 * 60 * 60;
		long ans = sec / mod;
		
		System.out.println(ans);

	}

}