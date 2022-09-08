import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] equation = br.readLine().toCharArray();
		
		// '(' : 0, '+' : 1, '-' : 1, '*' : 2, '/' : 2
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('(', 0); priority.put('-', 1); priority.put('+', 1); priority.put('*', 2); priority.put('/', 2);
		
		Stack<Character> post = new Stack<>();
		for(int i = 0, eSize = equation.length; i < eSize; i++) {
			char ch = equation[i];
			if(ch >= 'A' && ch <= 'Z') sb.append(ch);
			else {
				if(ch == '(') post.add(ch);
				else if(ch == ')') {
					char temp;
					while((temp = post.pop()) != '(') {
						sb.append(temp);
					}
				}else {
					while(!post.isEmpty() && priority.get(post.peek()) >= priority.get(ch)) {
						sb.append(post.pop());
					}
					post.add(ch);
				}
			}
		}
		
		while(!post.isEmpty())
			sb.append(post.pop());
		
		System.out.println(sb.toString());
	}

}