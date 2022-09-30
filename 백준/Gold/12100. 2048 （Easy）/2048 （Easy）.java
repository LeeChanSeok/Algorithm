import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[][] board;

	static final int[] dx = { -1, 1, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] order = new int[5];
		max = 0;
		dfs(0, order);
		System.out.println(max);
	}

	private static void dfs(int cnt, int[] order) {

		if (cnt == 5) {
			solution(order);
			return;
		}

		for (int d = 0; d < 4; d++) {
			order[cnt] = d;
			dfs(cnt + 1, order);
		}

	}

	private static void solution(int[] order) {
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; ++i)
			arr[i] = board[i].clone();

		int moveCnt = 5;
		int move = 0;
		for (int i = 0; i < moveCnt; ++i) {
			move = order[i];

			if (move == 0) {
				mergeUp(arr, move);
				moveUp(arr, move);
			} else if (move == 1) {
				mergeDown(arr, move);
				moveDown(arr, move);
			} else if (move == 2) {
				mergeLeft(arr, move);
				moveLeft(arr, move);
			} else if (move == 3) {
				mergeRight(arr, move);
				moveRight(arr, move);
			}

		}

		// Max number
		max = Math.max(max, calcMax(arr));

	}

	private static int calcMax(int[][] arr) {
		int max = 0;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				max = Math.max(max, arr[i][j]);
		return max;
	}

	private static void moveRight(int[][] arr, int move) {
		int j, k;
		for (int i = 0; i < N; ++i) {
			j = N-1; k = j-1;
			while (true) {
				while (j > 0 && arr[i][j] != 0)	--j;
				if (j <= 0)	break;
				if(k >= j) k = j - 1;
				
				while (k >= 0 && arr[i][k] == 0)	--k;
				if (k == -1)	break;
				arr[i][j] = arr[i][k];
				arr[i][k] = 0;
				
				--j; --k;

			}
		}

	}

	private static void mergeRight(int[][] arr, int move) {
		int j, k, num;
		for (int i = 0; i < N; ++i) {
			j = N-1;
			while (true) {
				// 1. merge 기준이 되는 수 찾기
				while (j > 0 && arr[i][j] == 0)	--j;
				if (j <= 0)	break;
				num = arr[i][j];
				k = j - 1;

				// 2. merge 할 수 찾기
				while (k >= 0 && arr[i][k] == 0) --k;
				if (k == -1)	break;
				if (arr[i][k] == num) {
					arr[i][j] += arr[i][j];
					arr[i][k] = 0;
					j = k-1;
				}
				else {
					j = k;
				}
			}
		}

	}

	private static void moveLeft(int[][] arr, int move) {

		int j, k;
		for (int i = 0; i < N; ++i) {
			j = 0; k = j+1;
			while (true) {
				while (j < N - 1 && arr[i][j] != 0)	++j;
				if (j >= N - 1)	break;
				if(k <= j) k = j + 1;
				
				while (k < N && arr[i][k] == 0)	++k;
				if (k == N)	break;
				arr[i][j] = arr[i][k];
				arr[i][k] = 0;
				
				++j; ++k;

			}
		}


	}

	private static void mergeLeft(int[][] arr, int move) {
		int j, k, num;
		for (int i = 0; i < N; ++i) {
			j = 0;
			while (true) {
				// 1. merge 기준이 되는 수 찾기
				while (j < N - 1 && arr[i][j] == 0)	++j;
				if (j >= N - 1)	break;
				num = arr[i][j];
				k = j + 1;

				// 2. merge 할 수 찾기
				while (k < N && arr[i][k] == 0)	++k;
				if (k == N)	break;
				if (arr[i][k] == num) {
					arr[i][j] += arr[i][j];
					arr[i][k] = 0;
					j = k + 1;
				}
				else {
					j = k;
				}
			}
		}

	}

	private static void moveDown(int[][] arr, int move) {

		int i, k;
		for (int j = 0; j < N; ++j) {
			i = N-1; k = i-1;
			while (true) {
				while (i > 0 && arr[i][j] != 0)	--i;
				if (i <= 0)	break;
				if(k >= i) k = i - 1;
				
				while (k >= 0 && arr[k][j] == 0) --k;
				if (k == -1)	break;
				arr[i][j] = arr[k][j];
				arr[k][j] = 0;
				
				--i; --k;

			}
		}

	}

	private static void mergeDown(int[][] arr, int move) {
		int i, k, num;
		for (int j = 0; j < N; ++j) {
			i = N-1;
			while (true) {
				// 1. merge 기준이 되는 수 찾기
				while (i > 0 && arr[i][j] == 0)	--i;
				if (i <= 0)	break;
				num = arr[i][j];
				k = i - 1;

				// 2. merge 할 수 찾기
				while (k >= 0 && arr[k][j] == 0) --k;
				if (k == -1)	break;
				if (arr[k][j] == num) {
					arr[i][j] += arr[i][j];
					arr[k][j] = 0;
					i = k-1;
				}else {
					i = k;
				}
			}
		}

	}

	private static void moveUp(int[][] arr, int move) {

		int i, k;
		for (int j = 0; j < N; ++j) {
			i = 0; k = i+1;
			while (true) {
				while (i < N - 1 && arr[i][j] != 0)	++i;
				if (i >= N - 1)	break;
				if(k <= i) k = i + 1;
				
				while (k < N && arr[k][j] == 0)	++k;
				if (k == N)	break;
				arr[i][j] = arr[k][j];
				arr[k][j] = 0;
				
				++i; ++k;

			}
		}

	}

	private static void mergeUp(int[][] arr, int move) {
		int i, k, num;
		for (int j = 0; j < N; ++j) {
			i = 0;
			while (true) {
				// 1. merge 기준이 되는 수 찾기
				while (i < N - 1 && arr[i][j] == 0)	++i;
				if (i >= N - 1)	break;
				num = arr[i][j];
				k = i + 1;

				// 2. merge 할 수 찾기
				while (k < N && arr[k][j] == 0)	++k;
				if (k == N)	break;
				if (arr[k][j] == num) {
					arr[i][j] += arr[i][j];
					arr[k][j] = 0;
					i = k+1;
				}else {
					i = k;
				}
			}
		}

	}

}