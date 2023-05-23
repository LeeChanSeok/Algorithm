import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());

		int answer = bfs(S);
		System.out.println(answer);
	}

	private static int bfs(int S) {
		boolean[][] visited = new boolean[S + 1][S + 1];
		int res = Integer.MAX_VALUE;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 1, 0 });

		int time = 0;
		while (!q.isEmpty()) {

			int qSize = q.size();
			while (qSize-- > 0) {
				int[] cur = q.poll();
				int screenCnt = cur[0];
				int clipCnt = cur[1];

				if (screenCnt == S)
					return time;

				// 1. 클립 보드에 저장
				if (screenCnt > 0 && !visited[screenCnt][screenCnt]) {
					visited[screenCnt][screenCnt] = true;
					q.offer(new int[] { screenCnt, screenCnt, time + 1 });
				}

				// 2. 붙여넣기
				if (clipCnt > 0 && screenCnt + clipCnt <= S && !visited[screenCnt + clipCnt][clipCnt]) {
					visited[screenCnt + clipCnt][clipCnt] = true;
					q.offer(new int[] { screenCnt + clipCnt, clipCnt });
				}

				// 3. 이모티콘 삭제
				if (screenCnt > 0 && !visited[screenCnt - 1][clipCnt]) {
					visited[screenCnt - 1][clipCnt] = true;
					q.offer(new int[] { screenCnt - 1, clipCnt, time + 1 });
				}

			}
			++time;

		}

		return -1;
	}

}
