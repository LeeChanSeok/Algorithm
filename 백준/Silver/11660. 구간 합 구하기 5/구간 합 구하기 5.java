import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] numArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				numArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			numArr[i][0] = numArr[i][0];
			for (int j = 1; j < N; j++) {
				numArr[i][j] = numArr[i][j - 1] + numArr[i][j];
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 1; i < N; i++) {
				numArr[i][j] = numArr[i - 1][j] + numArr[i][j];
			}
		}

		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			
			int ans = 0;
			ans = numArr[x2][y2];
			if(x1 != 0) ans -= numArr[x1-1][y2];
			if(y1 != 0) ans -= numArr[x2][y1-1];
			if(x1 != 0 && y1 != 0) ans += numArr[x1-1][y1-1];
			
			System.out.println(ans);
		}
	}

}