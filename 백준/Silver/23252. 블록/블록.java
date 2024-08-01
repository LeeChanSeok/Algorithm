import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			if (z > x) {
				System.out.println("No");
				continue;
			}
			if (x != 0 && y % 2 == 1)
				y--;
			if ((x - z) % 2 == 0 && y % 2 == 0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}

	}

}