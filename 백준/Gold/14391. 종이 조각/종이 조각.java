import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();

	static void dfs(int idx, int sum, boolean[][] visited) {

		int i = idx / M;
		int j = idx % M;
		while (idx != M * N && visited[i][j]) {
			idx++;
			i = idx / M;
			j = idx % M;
		}
		if (idx == N * M) {
			max = Math.max(max, sum);
			return;
		}

		// 각 종이 대입하기
		visited[i][j] = true;
		int num = map[i][j];

		// 해당 좌표의 1x1 종이 붙이기
		dfs(idx + 1, sum + num, visited);
		// 가로 길이 종이 붙이기
		num = map[i][j];
		int k = j + 1;
		for (; k < M; k++) {
			if(visited[i][k]) break;
			visited[i][k] = true;
			num = num * 10 + map[i][k];
			dfs(idx + 1, sum + num, visited);
		}
		for (k = k - 1; k > j; k--) {
			visited[i][k] = false;
		}

		// 세로 길이 종이 붙이기
		num = map[i][j];
		k = i + 1;
		for (; k < N; k++) {
			if(visited[k][j]) break;
			visited[k][j] = true;
			num = num * 10 + map[k][j];
			dfs(idx + 1, sum + num, visited);
		}
		for (k = k - 1; k > i; k--) {
			visited[k][j] = false;
		}

		visited[i][j] = false;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] nums = br.readLine().toCharArray();
			for (int j = 0; j < M; j++)
				map[i][j] = (int) (nums[j] - '0');
		}

		visited = new boolean[N][M];
		max = Integer.MIN_VALUE;
		dfs(0, 0, visited);
		System.out.println(max);
	}

}