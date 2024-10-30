import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();

		int cnt = 0;
		for (char c : arr) {
			if (c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u')
				++cnt;
		}

		System.out.println(cnt);

	}

}