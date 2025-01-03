import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[][] A = new int[4][2];
		while (T-- > 0) {
			for (int i = 0; i < A.length; i++) {
				st = new StringTokenizer(br.readLine());
				A[i][0] = Integer.parseInt(st.nextToken());
				A[i][1] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;
			int[] dist = new int[6];
			for (int i = 0; i < 4; ++i) {
				for (int j = i + 1; j < 4; ++j) {
					dist[idx++] = (int) (Math.pow(A[i][0] - A[j][0], 2) + Math.pow(A[i][1] - A[j][1], 2));
				}
			}

			if (isSquare(dist))
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		}

		bw.flush();
	}

	private static boolean isSquare(int[] A) {
		Arrays.sort(A);

		if (A[0] == A[1] && A[1] == A[2] && A[2] == A[3] && A[4] == A[5])
			return true;
		return false;
	}

}