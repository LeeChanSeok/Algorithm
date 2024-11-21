import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N;
		int l = 0, r = 11;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			String ans = br.readLine();

			if (ans.equals("too high") && r > N) {
				r = N;
			} else if (ans.equals("too low") && l < N) {
				l = N;
			} else if (ans.equals("right on")) {

				if (l < N && N < r)
					sb.append("Stan may be honest\n");
				else
					sb.append("Stan is dishonest\n");

				l = 0;
				r = 11;
			}

		}

		System.out.println(sb);

	}

}