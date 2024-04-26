import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int g = Integer.parseInt(br.readLine());

		int left = 1, right = 1;

		while (true) {
			int diff = right * right - left * left;
			if (right - left == 1 && diff > g)
				break;

			if (diff > g)
				++left;
			else if (diff < g)
				++right;
			else {
				sb.append(right).append('\n');
				++right;
			}
		}

		if (sb.toString().isEmpty())
			System.out.println("-1");
		else
			System.out.println(sb);

	}

}