import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		antiTriangle(n);
		Triangle(n);
		
		
		System.out.println(sb);
	}

	private static void Triangle(int n) {

		for(int i = 1; i < n; ++i) {
			
			for(int j = 1; j <= i; ++j) {
				sb.append(" ");
			}
			
			for(int j = 0; j < (n - i) * 2 - 1; j++) {
				sb.append("*");
			}
			sb.append('\n');
		}
		
	}

	private static void antiTriangle(int n) {

		for(int i = 0; i < n; ++i) {
			
			for(int j = n-i-1; j > 0; --j) {
				sb.append(" ");
			}
			
			for(int j = 0; j <= i * 2; j++) {
				sb.append("*");
			}
			sb.append('\n');
		}
		
	}
	
}