import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	static class Data implements Comparable<Data> {
		int x, y, z;

		public Data(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return this.z - o.z;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new char[n][n];
		for (int i = 0; i < n; ++i) {
			arr[i] = br.readLine().toCharArray();
		}

		System.out.println(bfs());

	}

	private static int bfs() {

		int[][] visited = new int[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(visited[i], (int) 1e9);
		}

		visited[0][0] = 0;
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(0, 0, 0));

		while (!pq.isEmpty()) {
			Data cur = pq.poll();

			if (cur.x == n - 1 && cur.y == n - 1)
				return cur.z;

			for (int d = 0; d < 4; ++d) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (arr[nx][ny] == '0') {
					if (visited[nx][ny] > cur.z + 1) {
						visited[nx][ny] = cur.z + 1;
						pq.offer(new Data(nx, ny, cur.z + 1));
					}
				} else {
					if (visited[nx][ny] > cur.z) {
						visited[nx][ny] = cur.z;
						pq.offer(new Data(nx, ny, cur.z));
					}

				}

			}

		}

		return -1;
	}

}