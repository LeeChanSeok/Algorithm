import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static String str;
	static double[] stack;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		int idx = 0;
		for(int i = 0, len = str.length(); i < len; ++i) {
			char c = str.charAt(i);
			
			if(c >= 'A' && c <= 'Z') stack[idx++] = nums[c - 'A'];
			else {
				stack[idx - 2] = calc(idx, c);
				--idx;
			}
			
		}
		
		System.out.printf("%.2f", stack[0]);
	}

	private static double calc(int idx, char c) {

		if(c == '+') return stack[idx -2] + stack[idx-1];
		if(c == '-') return stack[idx -2] - stack[idx-1];
		else if(c == '*') return stack[idx -2] * stack[idx-1];
		else if(c == '/') return stack[idx -2] / stack[idx-1];
		
		return 0;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		stack = new double[100];
		nums = new int[n];
		
		str = br.readLine();
		
		for(int i = 0; i < n; ++i) nums[i] = Integer.parseInt(br.readLine());
		
	}

}