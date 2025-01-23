import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		long ans = 0;
		for (int i = 0; i < str.length(); ++i) {
			ans = ans * 26 + (str.charAt(i) - 'A' + 1);
		}

		System.out.println(ans);

	}

}