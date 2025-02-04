import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 3; ++i) {
			int res = Integer.parseInt(st.nextToken());
			ans += Math.min(N, res);
		}
		
		System.out.println(ans);
		
	}

}