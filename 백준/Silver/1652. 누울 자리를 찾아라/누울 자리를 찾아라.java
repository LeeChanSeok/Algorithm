import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[][] room;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		room = new char[N][N];
		for (int i = 0; i < N; ++i)
			room[i] = br.readLine().toCharArray();

		System.out.println(find_Seat_verical(N) + " " + find_Seat_horizantal(N));
	}

	private static int find_Seat_verical(int N) {
		int answer = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - 1; ++j) {
				if (room[i][j] == '.' && room[i][j + 1] == '.') {
					++answer;
					j = j + 2;
					while (j < N - 1 && room[i][j] == '.')
						++j;
				}
			}
		}
		return answer;
	}

	private static int find_Seat_horizantal(int N) {
		int answer = 0;
		for (int j = 0; j < N; ++j) {
			for (int i = 0; i < N - 1; ++i) {
				if (room[i][j] == '.' && room[i + 1][j] == '.') {
					++answer;
					i = i + 2;
					while (i < N - 1 && room[i][j] == '.')
						++i;
				}
			}
		}
		return answer;
	}

}