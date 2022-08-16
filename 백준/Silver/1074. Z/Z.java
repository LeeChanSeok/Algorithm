import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, r, c;
	public static int nx, ny;
	public static int cnt;
	public static int[] dx = { 0, 0, 1, 1 };
	public static int[] dy = { 0, 1, 0, 1 };

	public static void recursive(int L, int x, int y, int cnt) {
		if (L == 0) {
			if (x == r && y == c) {
				System.out.println(cnt);
				System.exit(0);
			}
			return;
		}

		for (int d = dx.length - 1; d >= 0; d--) {
			nx = (int) (x + dx[d] * Math.pow(2, L)/2);
			ny = (int) (y + dy[d] * Math.pow(2, L)/2);
			if (r >= nx && c >= ny) {
				recursive(L - 1, nx, ny, cnt + d * (int) Math.pow(4, L-1));
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		cnt = 0;
		recursive(N, 0, 0, 0);
	}

}