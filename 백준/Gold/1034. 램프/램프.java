import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
					
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] zeroCnt = new int[N];
		String[] row = new String[N];
		
		for (int i = 0; i < N; ++i) {
			row[i] = br.readLine();
			for (int j = 0; j < M; ++j) {

				if (row[i].charAt(j) == '0')
					++zeroCnt[i];

			}
		}

		int K = Integer.parseInt(br.readLine());
		int max = 0;
		for (int i = 0; i < N; ++i) {
			if (zeroCnt[i] <= K && (zeroCnt[i] % 2 == K % 2)) {

				int cnt = 0;
				for (int i2 = 0; i2 < N; ++i2) {
					if (row[i].equals(row[i2]))
						++cnt;
				}

				max = Math.max(max, cnt);
			}
		}

		System.out.println(max);

	}

}