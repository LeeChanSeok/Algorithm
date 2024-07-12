import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int ans, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int ans = 2;
		for(int i = 1; i < N; ++i) {
			ans *= 3;
		}
	
		System.out.println(ans);
		
	}

	
}