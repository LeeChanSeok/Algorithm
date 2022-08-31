import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	static Map<Character, Integer> ISP = new HashMap<>();
	static Map<Character, Integer> ICP = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ISP.put('*', 2); ISP.put('/', 2); ISP.put('+', 2); ISP.put('-', 2); ISP.put('(', 2);
		ICP.put('*', 2); ICP.put('/', 2); ICP.put('+', 2); ICP.put('-', 2); ICP.put('(', 0);
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String inOrder = br.readLine();
			
			StringBuilder postOrder = new StringBuilder();
			Stack<Character> operator = new Stack<>();
			
			
			// 중위 순회 -> 후위 순회
			for(int s = 0, slen = inOrder.length(); s < slen; s++) {
				char c = inOrder.charAt(s);
				if (c >= '0' && c <= '9') postOrder.append(c);
				else {
					if(c == '(') operator.add('(');
					else if(c == ')') {
						while(operator.peek() != '(') {
							postOrder.append(operator.pop());
						}
						operator.pop();
					}
					else {
						while(!operator.isEmpty() && ISP.get(operator.peek()) >= ICP.get(c)) {
							postOrder.append(operator.pop());
						}
						operator.add(c);
					}
				}
			}
			postOrder.append(operator.pop());
			//후위 순회 계산
			Stack<Integer> operand  = new Stack<>();
			for(int s = 0, slen = postOrder.length(); s < slen; s++) {
				char c = postOrder.charAt(s);
				if (c >= '0' && c <= '9') operand.add(c - '0');
				else {
					int temp = 0;
					int back = operand.pop();
					int front = operand.pop();
					
					if(c == '+') temp = front + back;
					else if(c == '-') temp = front - back;
					else if(c == '*') temp = front * back;
					else if(c == '/') temp = front / back;
					
					operand.add(temp);
				}
			}
			
			System.out.println("#" + tc + " " + operand.pop());
			
		}

	}

}