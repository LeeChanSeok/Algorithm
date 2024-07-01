import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ans = null;
		for(int i = 3; i > 0; --i) {
			String in = br.readLine();
			char c = in.charAt(0);
			if(c >= '1' && c <= '9') {
				int num = Integer.parseInt(in);
				num += i;
				
				if(num % 15 == 0) ans = "FizzBuzz";
				else if(num % 3 == 0) ans = "Fizz";
				else if(num % 5 == 0) ans = "Buzz";
				else ans = String.valueOf(num);
				
				break;
			}
		}
		
		System.out.println(ans);

	}

}