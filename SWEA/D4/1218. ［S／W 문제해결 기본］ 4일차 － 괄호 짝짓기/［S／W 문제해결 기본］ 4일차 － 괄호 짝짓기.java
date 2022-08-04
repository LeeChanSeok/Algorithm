import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		int T = 10;
		int res;
		int N;
		char[] brackets;
		char bk;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Character> open = Arrays.asList('(', '<', '{', '[');
		List<Character> close = Arrays.asList(')', '>', '}', ']');
				
		Stack<Character> stack = new Stack<>();
		for(int tc = 1; tc <= T; tc++) {
			res = 1;
			N = Integer.parseInt(br.readLine());
			brackets = br.readLine().toCharArray();
			
			for(int i = 0; i < N; i++) {
				bk = brackets[i];
				if(open.contains(bk)) stack.push(bk);
				else {
					if(open.indexOf(stack.pop()) != close.indexOf(bk)) {
						res = 0;
						break;
					}
				}								
			}		
			System.out.printf("#%d %d\n",tc, res);
		}
	}
}