import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] coins = {25, 10, 5, 1};
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int C = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < 4; ++i) {
				int res = C / coins[i];
				sb.append(res + " ");
				C %= coins[i];
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

}