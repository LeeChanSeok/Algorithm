import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 1000 - Integer.parseInt(br.readLine());
		
		int ans = 0;
		int[] money = {500, 100, 50, 10, 5, 1};
		int idx = 0;
		while(n != 0) {
			ans += n / money[idx];
			n %= money[idx++];
		}
		System.out.println(ans);
	}

}