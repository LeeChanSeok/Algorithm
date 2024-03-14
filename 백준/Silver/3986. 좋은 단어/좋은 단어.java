import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			if (isGoodWord(br.readLine().toCharArray()))
				++ans;
		}

		System.out.println(ans);

	}

	private static boolean isGoodWord(char[] arr) {

		int len = arr.length;
		if (len % 2 == 1)
			return false;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < len; ++i) {

			if (!stack.isEmpty()) {
				if (stack.peek() == arr[i]) {
					stack.pop();
				} else {
					stack.push(arr[i]);
				}

			} else {
				stack.push(arr[i]);
			}

		}

		return (stack.isEmpty());
	}

}