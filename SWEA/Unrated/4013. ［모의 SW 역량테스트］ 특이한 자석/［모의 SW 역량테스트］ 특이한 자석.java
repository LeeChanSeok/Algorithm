import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static int K, N;
	static LinkedList<Character>[] magnet;
	static boolean[] visit;
	static boolean direction;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		N = 4;
		for (int tc = 1; tc <= T; tc++) {

			K = Integer.parseInt(br.readLine());

			magnet = new LinkedList[N];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				magnet[i] = new LinkedList<>();
				for (int j = 0; j < 8; j++) {
					magnet[i].add(st.nextToken().charAt(0));
				}
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int no = Integer.parseInt(st.nextToken()) -1 ;
				direction = (st.nextToken().charAt(0) == '1') ? true : false;
				visit = new boolean[N];

				recursive(no, direction);
			}

			int score = 0;
			for (int i = 0; i < N; i++) {
				score += Math.pow(2, i) * (magnet[i].get(0) - '0');
			}
			sb.append("#" + tc + " " + score + "\n");
		} // tc 종료

		bw.write(sb.toString());
		bw.close();

	}

	private static void recursive(int no, boolean direction) {
		if (visit[no])	return;

		visit[no] = true;

		// 왼쪽 비교
		if (no > 0 && !visit[no-1] && magnet[no - 1].get(2) != magnet[no].get(6))
			recursive(no - 1, !direction);
		// 오른쪽 비교
		if (no < N - 1 && !visit[no+1] && magnet[no + 1].get(6) != magnet[no].get(2))
			recursive(no + 1, !direction);

		rotate(no, direction);
	}

	private static void rotate(int no, boolean direction) {
		if (direction)
			magnet[no].addFirst(magnet[no].pollLast());
		else
			magnet[no].add(magnet[no].poll());
	}

}