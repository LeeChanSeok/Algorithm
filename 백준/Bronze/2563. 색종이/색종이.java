import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N = 100;
		int[][] paper = new int[N][N];
		int x, y;
		int cnt = 0;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			for(int i = x; i< x + 10; i++) {
				for(int j = y; j < y + 10; j++) {
					if(paper[i][j] == 0) {
						paper[i][j] = 1;
						cnt++;
					}
				}
			} // N번째 탐색 종료
			
		}// test-case end
		System.out.println(cnt);
	}
}