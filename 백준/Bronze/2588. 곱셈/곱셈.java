import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int total = 0;
		int delta = 1; 
		while(num2 != 0) {
			int digit = num2 % 10;
			num2 /= 10;
			
			int res = num1 * digit;
			total += res * delta;
			delta *= 10;
			sb.append(res).append('\n');
		}
		
		sb.append(total);
		System.out.println(sb);

	}

}