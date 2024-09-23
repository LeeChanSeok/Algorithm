import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			String str = br.readLine();

			int cnt = 0;
			int len = str.length();
			for (int i = 3; i <= len; ++i) {
				if (str.subSequence(i - 3, i).equals("WOW"))
					++cnt;
			}
			
			System.out.println(cnt);

		}

	}

}