import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		int[] ans = {1, 0};
		while(k-- > 0) {
			int a = ans[0];
			int b = ans[1];
			
			ans[0] = b;
			ans[1] = b + a;
		}
		
		System.out.println(ans[0] + " " + ans[1]);
	}
}