import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		long ans1 = (a - K) / M + 1;
		if ((a - K) % M != 0)
			++ans1;

		long ans2 = 0;

		if (a <= K)
			ans2 = 1;
		else if (a - K >= N - 1)
			ans2 = N;
		else {
			ans2 = a - K + 1;

		}

		System.out.println(ans2 + " " + ans1);

	}

}