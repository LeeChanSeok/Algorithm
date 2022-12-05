import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, W, B;
	public static int[] dx = { 0, 0, 1, 1 };
	public static int[] dy = { 0, 1, 0, 1 };
	public static char[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		W = B = 0;
		colorPaper(N, 0, 0);
		
		System.out.println(W);
		System.out.println(B);
	}
	
	public static void colorPaper(int N, int x, int y) {
		
		if (isSquare(N, x, y)) {
			if(map[x][y] == '1') ++B;
			else ++W;
			return;
		}
		
		for(int d = 0, dSize = dx.length; d < dSize; d++) {
			colorPaper(N/2, x + dx[d]*N/2 , y + dy[d]*N/2);
		}
		
	}
	
	public static boolean isSquare(int N, int x, int y) {

		char bit = map[x][y];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[x + i][y + j] != bit)
					return false;
			}
		}

		return true;
	}

}
