import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] stones = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			stones[i] = Integer.parseInt(st.nextToken());

		int s = Integer.parseInt(br.readLine()) - 1;

		boolean[] visited = new boolean[N];
		visited[s] = true;

		Queue<Integer> q = new LinkedList<>();
		q.offer(s);

		int answer = 1;

		int cur, next;
		while (!q.isEmpty()) {
			cur = q.poll();

			// 1. 앞
			next = cur + stones[cur];
			if (next < N && !visited[next]) {
				++answer;
				visited[next] = true;
				q.offer(next);
			}

			// 1. 뒤
			next = cur - stones[cur];
			if (next >= 0 && !visited[next]) {
				++answer;
				visited[next] = true;
				q.offer(next);
			}
		}
		
		System.out.println(answer);

	}

}