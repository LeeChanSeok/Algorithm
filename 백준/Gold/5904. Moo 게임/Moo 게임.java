import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static char c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int len = 3;
		int k = 0;

		while (len < n) {
			++k;
			len = len * 2 + (k + 3);
		}

		c = '\0';

		recursive(len, k + 3, n);

		System.out.println(c);
	}

	private static void recursive(int len, int mid_len, int n) {

		if (n <= 3) {
			if (n == 1)
				c = 'm';
			else
				c = 'o';
			return;
		}

		int left = (len - mid_len) / 2;

		if (n <= left)
			recursive(left, mid_len - 1, n);
		else if (n > left + mid_len)
			recursive(left, mid_len - 1, n - left - mid_len);
		else {
			if (n - left == 1)
				c = 'm';
			else
				c = 'o';
		}

	}

}