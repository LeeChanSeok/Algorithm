import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static final int SIZE = 26;

	static int N, R, C;
	static char X, Y, Z, V;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";
		while ((str = br.readLine()) != null) {
			N = Integer.parseInt(str);
			arr = new char[N][N];
			for (int i = 0; i < N; ++i) {
				arr[i] = br.readLine().toCharArray();
			}

			solution();
			System.out.println(R + " " + C + " " + V);
		}

	}

	private static void solution() {
		int[] alpha = new int[SIZE];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				++alpha[arr[i][j] - 'A'];
			}
		}
		
		X = Y = Z = '\0';
		for (int i = 0; i < SIZE; ++i) {
			if (alpha[i] == 1) {
				X = (char) (i + 'A');
			} else if (alpha[i] == N - 1) {
				Y = (char) (i + 'A');
			}else if (alpha[i] == N + 1) {
				Z = (char) (i + 'A');
			}
		}
		
		V = Y;
		if(X == '\0') {

			for(int i = 0; i < N; ++i) {
				boolean isAlpha = false;
				for(int j = 0; j < N; ++j) {
					if(arr[i][j] == Y) {
						isAlpha = true;
						break;
					}
				}
				if(!isAlpha) {
					R = i + 1;
					break;
				}
			}
			for(int j = 0; j < N; ++j) {
				boolean isAlpha = false;
				for(int i = 0; i < N; ++i) {
					if(arr[i][j] == Y) {
						isAlpha = true;
						break;
					}
				}
				if(!isAlpha) {
					C = j + 1;
					break;
				}
			}
		}
		else {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (arr[i][j] == X) {
						R = i + 1;
						C = j + 1;
						return;
					}
				}
			}
		}

	}

}