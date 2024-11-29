import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			Arrays.fill(arr[i], -1);
		}

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; ++i) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; ++j) {
				if (row[j] == 'c') {
					q.offer(new int[] { i, j });
					arr[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int nx = cur[0];
			int ny = cur[1] + 1;
			if (ny == M)
				continue;
			if (arr[nx][ny] != -1)
				continue;

			arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
			q.offer(new int[] { nx, ny });
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				bw.write(arr[i][j] + " ");
			}
			bw.write('\n');
		}

		bw.flush();
		bw.flush();

	}
}