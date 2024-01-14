import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int m = 2;
		
		while(m <= n) {
			if(n % m == 0) {
				sb.append(m).append('\n');
				n /= m;
			}else {
				++m;
			}
		}
		
		System.out.println(sb);

	}

}