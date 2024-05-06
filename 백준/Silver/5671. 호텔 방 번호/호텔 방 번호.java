import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] room;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		room = new int[5001];
		recursive(0, 0);

		for (int i = 1; i <= 5000; ++i) {
			room[i] += room[i - 1];
		}

		String str;
		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			sb.append(room[m] - room[n - 1]).append('\n');
		}

		System.out.println(sb);

	}

	private static void recursive(int num, int flag) {

		if (num > 5000)
			return;

		room[num] = 1;
		for (int i = 0; i < 10; ++i) {
			if ((flag & (1 << i)) != 0)
				continue;
			recursive(num * 10 + i, flag | (1 << i));
		}

	}

}