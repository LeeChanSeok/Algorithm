import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[][] D = new long[N + 1][2];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) {
			long num = Long.parseLong(st.nextToken());
			D[i][0] = num + Math.min(D[i-1][0], D[i-1][1]);
			D[i][1] = D[i-1][0];
		}

		System.out.println(Math.min(D[N][0], D[N][1]));
	}

}