import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		long total = 0;

		for (int i = 0; i < n; ++i) {
			int h = Integer.parseInt(br.readLine());

			while (!stack.isEmpty() && stack.peek() <= h)
				stack.pop();
			total += stack.size();

			stack.push(h);
		}

		System.out.println(total);
	}

}