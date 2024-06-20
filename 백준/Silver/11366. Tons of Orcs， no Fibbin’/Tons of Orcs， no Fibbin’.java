import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = 50;
		int[] fibo = new int[n];
		fibo[1] = fibo[2] = 1;
		for (int i = 3; i < n; ++i) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		while (true) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if ((a == 0) && (b == 0) && (c == 0))
				break;

			int ans = 0;
			if(a == 0 && b == 0) ans = 0;
			else ans = a * fibo[c] + b * fibo[c + 1];
			
			sb.append(ans).append('\n');
		}

		System.out.println(sb);

	}

}