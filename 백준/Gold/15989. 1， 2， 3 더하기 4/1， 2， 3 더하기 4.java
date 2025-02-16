import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int MAXN = 10000;
		long[][] D = new long[MAXN + 1][4];

		D[1][1] = 1;
		D[2][1] = 1; D[2][2] = 1;
		D[3][1] = 1; D[3][2] = 1; D[3][3] = 1;
		
		for (int i = 4; i <= MAXN; ++i) {
			D[i][1] = D[i - 1][1];
			D[i][2] = D[i - 2][1] + D[i - 2][2];
			D[i][3] = D[i - 3][1] + D[i - 3][2] + D[i - 3][3];
		}

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; ++i) {
			int num = Integer.parseInt(br.readLine());
			sb.append(D[num][1] + D[num][2] + D[num][3]).append("\n");
		}
		
		System.out.println(sb);
	}

}