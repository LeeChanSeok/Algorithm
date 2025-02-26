import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P1 = Integer.parseInt(st.nextToken());
		int P2 = Integer.parseInt(st.nextToken());

		int ans = -1;
		while (P1 != P2) {
			if (P1 > P2)
				P2 += Y;
			else
				P1 += X;

			if (P1 > 10000 && P2 > 10000) {
				ans = -1;
				break;
			}
			ans = P1;
		}

		System.out.println(ans);

	}

}