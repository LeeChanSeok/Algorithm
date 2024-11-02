import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if (isPalindrome(num))
				bw.write("1\n");
			else
				bw.write("0\n");
		}

		bw.flush();
	}

	private static boolean isPalindrome(int num) {

		for (int i = 2; i <= 64; ++i) {
			List<Integer> list = num2str(num, i);

			boolean isPal = true;
			int l = 0, r = list.size() - 1;
			while (l < r) {
				if (list.get(l++) != list.get(r--)) {
					isPal = false;
				}

			}
			if (isPal)
				return true;

		}
		return false;
	}

	private static List<Integer> num2str(int num, int i) {

		List<Integer> list = new ArrayList<>();
		while (num != 0) {
			list.add(num % i);
			num /= i;

		}
		return list;
	}

}