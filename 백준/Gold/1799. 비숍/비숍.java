import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static char[][] board;
	static int max;
	static int total, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		total = N*N;
		board = new char[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j)
				board[i][j] = st.nextToken().charAt(0);
		}
		
		int ans = 0;
		
		max = 0;
		subSet(0, 0, 0, 0, 0);
		ans += max;
		
		max = 0;
		subSet(0, 1, 0, 0, 0);
		ans += max;
		
		System.out.println(ans);
	}
	private static void subSet(int x, int y, int diagCheck, int antidiagCheck, int put) {

		max = Math.max(max, put);
		if(y >= N) {
			++x;
			if((y&1) == 0) {
				y = 1;
			}
			else y = 0;
		}
		
		if(x >= N) return;
		
		// 현재 위치에 비숍을 두는 경우
		if(board[x][y] == '1') {
			// 비숍을 둘 수 있는 경우
			int diagonal = x - y + 10;
			int antidiagonal = x + y;
			
			if((diagCheck & (1 << diagonal)) == 0 && (antidiagCheck & (1 << antidiagonal)) == 0) {
				subSet(x, y+2, diagCheck | (1 << diagonal) , antidiagCheck | (1 << antidiagonal), put+1);
			}
			
		}
			
		// 현재 위치에 비숍을 두지 않는 경우
		subSet(x, y+2, diagCheck , antidiagCheck, put);
		
	}

}