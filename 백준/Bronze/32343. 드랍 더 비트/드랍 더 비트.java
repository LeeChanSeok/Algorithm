import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int res = 0;
		if (a + b <= N) {
			int K = N - (a + b);
			res = (((1 << N) - 1) - ((1 << K) - 1));
		} else {
			int K = (a + b) - N;
			res = (((1 << N) - 1) - ((1 << K) - 1));
		}

		System.out.println(res);
	}

}