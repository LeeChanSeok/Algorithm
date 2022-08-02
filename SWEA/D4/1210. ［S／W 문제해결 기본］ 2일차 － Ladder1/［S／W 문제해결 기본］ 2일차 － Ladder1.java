import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// {좌, 하, 우}에 대한 방향 delta
	public static int[] dr = { 0, -1, 0 };
	public static int[] dc = { -1, 0, 1 };

	public static int dir;// 0 : 좌, 1 : 상, 2 : 우

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/hw/d0802/N1210/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		int N = 100;
		for (int tc = 1; tc <= T; tc++) {

			// arr 초기화
			char[][] arr = new char[N][N];
			br.readLine();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					arr[i][j] = st.nextToken().charAt(0);
			}

			for (int s = 0; s < N; s++) {
				dir = 1; // 시작 방향 아래

				if (arr[N - 1][s] == '2') {

					int r = N - 1;
					int c = s;

					while (r > 0) { // 끝을 벗어나거나 목적지에 도착하기 전까지 계속 수행
						if (dir % 2 == 1) { // 진행 방향이 아래인 경우, 좌 또는 우로 진행여부 판단
							if (c - 1 >= 0 && arr[r][c - 1] == '1')
								dir = 0;
							else if (c + 1 < N && arr[r][c + 1] == '1')
								dir = 2;
						} else { // 진행 방향이 좌 또는 우 인 경우, 아래 방향으로 진행여부 판단
							if (arr[r - 1][c] == '1')
								dir = 1;
						}
						// 진행 방향으로 이동
						r += dr[dir];
						c += dc[dir];
					}
					
					System.out.printf("#%d %d\n", tc, c);
					break;
				}
			}

		}
	}
}