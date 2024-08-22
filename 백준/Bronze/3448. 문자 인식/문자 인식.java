import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {

			int total = 0;
			int cnt = 0;
			String str = "";
			while (!(str = br.readLine()).equals("")) {

				for (int i = 0; i < str.length(); ++i) {
					++total;
					if (str.charAt(i) == '#')
						++cnt;
				}
			}

			cnt = total - cnt;
			double rate = (double) cnt / (double) total * 100;
			rate = Math.round(rate * 10) / 10.0;
			if (rate == (int) rate)
				System.out.printf("Efficiency ratio is %d%%.\n", (int) rate);
			else
				System.out.printf("Efficiency ratio is %.1f%%.\n", rate);

		}

	}

}