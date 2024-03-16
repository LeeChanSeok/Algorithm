import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		Stack<Character> pre = new Stack<>();
		Stack<Character> post = new Stack<>();
		
		int L = Integer.parseInt(br.readLine());
		while (L-- > 0) {
			char[] arr = br.readLine().toCharArray();

			
			for (char c : arr) {
				if (c == '<') {
					if(!pre.isEmpty()) post.push(pre.pop());
				} else if (c == '>') {
					if(!post.isEmpty()) pre.push(post.pop());
				} else if (c == '-') {
					if(!pre.isEmpty()) pre.pop();
				} else {
					pre.push(c);
				}
			}
			
			StringBuilder presb = new StringBuilder();
			StringBuilder postsb = new StringBuilder();
			
			while(!pre.isEmpty()) presb.append(pre.pop());
			while(!post.isEmpty()) postsb.append(post.pop());
			
			ans.append(presb.reverse()).append(postsb).append('\n');
		}
		
		System.out.println(ans);

	}

}