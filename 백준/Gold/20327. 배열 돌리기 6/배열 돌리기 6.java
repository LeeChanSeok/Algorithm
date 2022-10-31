import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int M = (int) Math.pow(2, N);

		int[][] board = new int[M][M];
		int[][] move = new int[M][M];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		int k, l;
		while (R-- > 0) {
			st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			if(Move(N, M, k, l, board, move)) {
				copyArr(board, move, M);
			}

		}

		
		for(int i = 0; i < M; ++i) {
			for(int j = 0; j < M; ++j) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}

	private static boolean Move(int N, int M, int k, int l, int[][] board, int[][] move) {

		int r = (int) Math.pow(2, l);
		// 1. 각 부분 배열을 상하 반전
		if (k == 1) {
			if (l == 0)	return false;

			// 각 부분 배열의 시작 위치
			for (int i = 0; i < M; i += r) {
				for (int j = 0; j < M; j += r) {

					// 상하 반전
					for (int i2 = 0; i2 < r; ++i2) {
						for (int j2 = 0; j2 < r; ++j2) {
							move[i + i2][j + j2] = board[i + r - 1 - i2][j + j2];
						}
					}

				}
			}

		}
		// 2. 각 부분 배열을 좌우 반전
		else if (k == 2) {
			if (l == 0)	return false;

			// 각 부분 배열의 시작 위치
			for (int i = 0; i < M; i += r) {
				for (int j = 0; j < M; j += r) {

					// 상하 반전
					for (int i2 = 0; i2 < r; ++i2) {
						for (int j2 = 0; j2 < r; ++j2) {
							move[i + i2][j + j2] = board[i + i2][j + r - 1 - j2];
						}
					}

				}
			}

		}
		// 3. 각 부분 배열을 오른쪽 90 회전
		else if (k == 3) {
			if (l == 0)	return false;

			// 각 부분 배열의 시작 위치
			for (int i = 0; i < M; i += r) {
				for (int j = 0; j < M; j += r) {

					// 상하 반전
					for (int i2 = 0; i2 < r; ++i2) {
						for (int j2 = 0; j2 < r; ++j2) {
							move[i + i2][j + j2] = board[i + r - 1 - j2][j + i2];
						}
					}

				}
			}

		}
		// 4. 각 부분 배열을 왼쪽 90 회전
		else if (k == 4) {
			if (l == 0)	return false;

			// 각 부분 배열의 시작 위치
			for (int i = 0; i < M; i += r) {
				for (int j = 0; j < M; j += r) {

					// 상하 반전
					for (int i2 = 0; i2 < r; ++i2) {
						for (int j2 = 0; j2 < r; ++j2) {
							move[i + i2][j + j2] = board[i + j2][j + r - 1 - i2];
						}
					}

				}
			}

		}
		// 5 ~ 8 부분 배열을 한 칸으로 생각하고 적용
		// 5. 상하 반전
		else if (k == 5) {
			// 각 부분 배열의 시작 위치
			for (int i = 0; i < M; i += r) {
				for (int j = 0; j < M; j += r) {

					// 상하 반전
					for (int i2 = 0; i2 < r; ++i2) {
						for (int j2 = 0; j2 < r; ++j2) {
							move[i + i2][j + j2] = board[M - i - r + i2][j + j2];
						}
					}

				}
			}
			
		}
		// 6. 좌우 반전
		else if (k == 6) {
			// 각 부분 배열의 시작 위치
			for (int i = 0; i < M; i += r) {
				for (int j = 0; j < M; j += r) {

					// 상하 반전
					for (int i2 = 0; i2 < r; ++i2) {
						for (int j2 = 0; j2 < r; ++j2) {
							move[i + i2][j + j2] = board[i + i2][M - j - r + j2];
						}
					}

				}
			}
		}
		// 7. 오른쪽 90도 회전
		else if (k == 7) {
			
			// 각 부분 배열의 시작 위치
			for (int i = 0; i < M; i += r) {
				for (int j = 0; j < M; j += r) {

					// 상하 반전
					for (int i2 = 0; i2 < r; ++i2) {
						for (int j2 = 0; j2 < r; ++j2) {
							move[i + i2][j + j2] = board[M - j - r + i2][i + j2];
						}
					}

				}
			}

		}
		// 8. 왼쪽 90도 회전
		else if (k == 8) {

			// 각 부분 배열의 시작 위치
			for (int i = 0; i < M; i += r) {
				for (int j = 0; j < M; j += r) {

					// 상하 반전
					for (int i2 = 0; i2 < r; ++i2) {
						for (int j2 = 0; j2 < r; ++j2) {
							move[i + i2][j + j2] = board[j + i2][M - i - r + j2];
						}
					}

				}
			}
		}

		return true;
	}

	private static void copyArr(int[][] board, int[][] move, int M) {
		for (int i = 0; i < M; ++i)
			board[i] = move[i].clone();
	}

}