import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int time, cnt;
	static final int MAX_SIZE = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		
		if (N >= K) {
			time = N - K;
			cnt = 1;

		} else {
			solution(N, K);
		}
		sb.append(time + "\n");
		sb.append(cnt + " ");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	private static void solution(int N, int K) {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		boolean[] visited = new boolean[K*2 + 1];
		Queue<Integer> visit = new LinkedList<>();
		visited[N] = true;
		
		while (!q.isEmpty()) {

			int qSize = q.size();
			visit.clear();
			while (qSize-- > 0) {
				int cur = q.poll();

				if (cur == K) {
					++cnt; 
				}
				
				// x2
				int pos = cur * 2;
				if (pos <= 2 * K && !visited[pos]) {
					q.offer(pos);
					visit.add(pos);
				}

				// +1
				pos = cur + 1;
				if (pos <= K && !visited[pos]) {
					q.offer(pos);
					visit.add(pos);
				}

				// -1
				pos = cur - 1;
				if (pos >= 0 && !visited[pos]) {
					q.offer(pos);
					visit.add(pos);
				}

			}
			for(int num : visit) visited[num] = true;
			if(cnt != 0) return;
			++time;

		}

	}

}