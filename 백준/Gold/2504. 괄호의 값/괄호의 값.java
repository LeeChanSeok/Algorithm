import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		
		int ans = 0;
		int len = arr.length;
		if(len%2 == 0) {
			int[] cnt = new int[4];
			for(int i = 0; i < len; ++i) {
				if(arr[i] == '(') ++cnt[0]; 
				else if(arr[i] == ')') ++cnt[1]; 
				else if(arr[i] == '[') ++cnt[2]; 
				else if(arr[i] == ']') ++cnt[3]; 
			}
			
			if(cnt[0] == cnt[1] && cnt[2] == cnt[3]) {
				ans = isBracket(arr);
			}
			
			//ans = isBracket(arr);
			
		}
		
		System.out.println(ans);		

	}

	private static int isBracket(char[] arr) {

		Stack<Integer> stack = new Stack<>();
		
		
		int len = arr.length;
		for(int i = 0; i < len; ++i) {
			
			if(arr[i] == '(' || arr[i] == '[') stack.add(-(int)arr[i]);
			else {
				if(stack.isEmpty()) return 0;
				
				int open = (arr[i] == ')')?-(int)'(':-(int)'[';
				int num = (arr[i] == ')')?2:3;
				
				if(stack.peek() == open) {
					stack.pop();
					stack.add(num);
				}
				else {
					int temp = 0;
					while(!stack.isEmpty() && stack.peek() != open) {
						if(stack.peek() > 0) temp += stack.pop();
						else if(stack.peek() == -(int)')' 
								|| stack.peek() == -(int)']' 
								|| stack.peek() != open) return 0;
					}
					
					stack.pop();
					stack.add(temp * num);
				
				}
				
			}
		}
		
		int ans = 0;
		while(!stack.isEmpty()) {
			if(stack.peek() < 0) return 0;
			ans += stack.pop();
		}
		
		return ans;
	}

}