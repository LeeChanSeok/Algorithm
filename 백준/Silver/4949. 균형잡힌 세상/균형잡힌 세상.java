import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		String str;
		char c;
		boolean isRight;
		while(true) {
			str = br.readLine();
			if(str.charAt(0) == '.') break;
			
			stack.clear();
			isRight = true;
			for(int i = 0, len = str.length(); i < len; ++i) {
				c = str.charAt(i);
				if(c == '(' || c == '[') stack.push(c);
				else if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
					else {
						isRight = false;
						break;
					}
				}else if(c == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
					else {
						isRight = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) isRight = false;
			
			if(isRight) System.out.println("yes");
			else System.out.println("no");
			
		}

	}

}