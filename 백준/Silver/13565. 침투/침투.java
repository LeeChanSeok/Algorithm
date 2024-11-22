import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		for (int i = 0; i < N; ++i) {
			arr[i] = br.readLine().toCharArray();
		}

		if (isTransfer())
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	private static boolean isTransfer() {

		int DELTA = 1000;
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < M; ++i) {
			if (arr[0][i] == '0') {
				q.offer(i);
				visited[0][i] = true;
			}
		}

		while (!q.isEmpty()) {
			int x = q.peek() / DELTA;
			int y = q.poll() % DELTA;

			if (x == N - 1)
				return true;

			for (int d = 0; d < 4; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (visited[nx][ny])
					continue;
				if (arr[nx][ny] == '1')
					continue;

				visited[nx][ny] = true;
				q.offer(nx * DELTA + ny);

			}
		}

		return false;
	}

}