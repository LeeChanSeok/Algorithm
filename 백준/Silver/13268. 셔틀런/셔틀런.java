import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine()) % 100;

		int[] con = new int[] { 5, 10, 15, 20 };

		int pos = 0;
		int dir = 1;
		int turn = 0;
		while (A-- > 0) {
			pos += dir;
			if (pos == 0)
				dir = 1;
			else if (pos == con[turn]) {
				dir = -1;
				turn = (turn + 1) % 4;
			}
		}

		int ans = 0;
		if (pos != 0)
			ans = (pos - 1) / 5 + 1;
		System.out.println(ans);
	}

}