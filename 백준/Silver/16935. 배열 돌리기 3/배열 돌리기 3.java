import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void PrintArr(int[][] arr) {
		for(int[] row : arr) {
			for(int a : row)
				System.out.printf(a + " ");
			System.out.println();
		}
	}
	
	public static int[][] rotate(int[][] arr, int N, int M, int R) {

		int[][] new_arr = null;
		if (R == 1) {// 상하 반전
			new_arr = new int[N][M];
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M; j++) {
					new_arr[i][j] = arr[N - 1 - i][j];
					new_arr[N - 1 - i][j] = arr[i][j];
				}
			}

		} // 상하 반전 종료
		else if (R == 2) { // 좌우반전
			new_arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					new_arr[i][j] = arr[i][M - 1 - j];
					new_arr[i][M - 1 - j] = arr[i][j];
				}
			}
		} // 좌우 반전 종료
		else if (R == 3) { // 오른쪽 90도 회전
			new_arr = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					new_arr[i][j] = arr[N - 1 - j][i];
				}
			}
		} else if (R == 4) { // 왼쪽 90도 회전
			new_arr = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					new_arr[i][j] = arr[j][M - 1 - i];
				}
			}
		} else if (R == 5) {
			new_arr = new int[N][M];

			// 4 - > 1
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					new_arr[i][j] = arr[i + N / 2][j];
				}
			}

			// 1 - > 2
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					new_arr[i][j] = arr[i][j - M / 2];
				}
			}

			// 2 - > 3
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					new_arr[i][j] = arr[i - N / 2][j];
				}
			}

			// 3 - > 4
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					new_arr[i][j] = arr[i][j + M / 2];
				}
			}

		}else if (R == 6) {
			new_arr = new int[N][M];

			// 4 - > 1
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) {
					new_arr[i][j] = arr[i][j + M / 2];
				}
			}

			// 1 - > 2
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					new_arr[i][j] = arr[i + N / 2][j];
				}
			}

			// 2 - > 3
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					new_arr[i][j] = arr[i][j - M / 2];
				}
			}

			// 3 - > 4
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					new_arr[i][j] = arr[i - N / 2][j];
				}
			}
		}
		return new_arr;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int com;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			com = Integer.parseInt(st.nextToken());
			arr = rotate(arr, arr.length, arr[0].length, com);			
		}
		PrintArr(arr);
	}
}