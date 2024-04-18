import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static final int alphaCnt = 'z' - 'a' + 1;
	static char[] arr;
	static int n;
	static int len;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			ans = 2;

			arr = br.readLine().toCharArray();
			len = arr.length;
			
			isPalindrome(0, len - 1, 0);

			sb.append(ans).append('\n');

		}

		System.out.println(sb);

	}

	private static void isPalindrome(int l, int r, int del) {

		if (l >= r) {
			if (del == 0)
				ans = 0;
			else if (del == 1)
				ans = 1;

			return;
		}

		if (arr[l] == arr[r])
			isPalindrome(l + 1, r - 1, del);
		else {
			if (del == 1)
				return;
			isPalindrome(l + 1, r, del + 1);
			isPalindrome(l, r - 1, del + 1);
		}

	}

}