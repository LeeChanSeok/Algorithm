import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}

		// ver1
		{
			int max = arr[N - 1];
			int ans = 1;
			for (int i = N - 2; i >= 0; --i) {
				if (arr[i] > max) {
					max = arr[i];
					++ans;
				}
			}
			System.out.println(ans);
		}

		// ver2
//		{
//			Stack<Integer> stack = new Stack<>();
//			for (int i = 0; i < N; ++i) {
//				int num = arr[i];
//
//				while (!stack.isEmpty() && stack.peek() <= num) {
//					stack.pop();
//				}
//				stack.push(num);
//			}
//
//			System.out.println(stack.size());
//		}

	}

}