import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();
		int N = arr.length;

		String answer = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";

		for (int i = 0; i < N - 2; ++i) {
			for (int j = i + 1; j < N - 1; ++j) {

					String str = "";

					for (int ii = i; ii >= 0; --ii)
						str += arr[ii];
					for (int jj = j; jj > i; --jj)
						str += arr[jj];
					for (int kk = N - 1; kk > j; --kk)
						str += arr[kk];

					if (str.compareTo(answer) < 0)
						answer = str;
			}
		}

		System.out.println(answer);
	}

}