import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max;
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		max = checkColor(map);
		max = Math.max(max, Change(map));
		System.out.println(max);

	}

	public static int Change(char[][] map) {
		int max = 0;
		int N = map.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] != map[i][j + 1]) {
					swap(map, i, j, i, j + 1);
					max = Math.max(max, checkColor(map));
					swap(map, i, j + 1, i, j);
				}
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (map[i][j] != map[i + 1][j]) {
					swap(map, i, j, i + 1, j);
					max = Math.max(max, checkColor(map));
					swap(map, i + 1, j, i, j);
				}
			}
		}
		return max;
	}

	public static void swap(char[][] map, int x1, int y1, int x2, int y2) {
		char temp = map[x1][y1];
		map[x1][y1] = map[x2][y2];
		map[x2][y2] = temp;
	}

	public static int checkColor(char[][] map) {
		int N = map.length;
		int max = 0;
		int i, j, cnt;
		char color;
		// 1. 행 검사
		for (i = 0; i < N; i++) {
			color = map[i][0];
			j = 1;
			cnt = 1;
			while (j < N) {
				if (map[i][j] == color)
					cnt++;
				else {
					max = Math.max(max, cnt);
					cnt = 1;
					color = map[i][j];
				}
				j++;
			}
			max = Math.max(max, cnt);
		}

		// 2. 열검사
		for (j = 0; j < N; j++) {
			color = map[0][j];
			i = 1;
			cnt = 1;
			while (i < N) {
				if (map[i][j] == color)
					cnt++;
				else {
					max = Math.max(max, cnt);
					cnt = 1;
					color = map[i][j];
				}
				i++;
			}
			max = Math.max(max, cnt);
		}

		return max;
	}

}