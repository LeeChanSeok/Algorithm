import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String str = br.readLine();

			int res = (str.charAt(0) - '0') + (str.charAt(2) - '0');
			System.out.println(res);

		}

	}

}