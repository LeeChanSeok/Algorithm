import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] times;
	static int[] ranks;
	static int[] cost;
	static List<Integer>[] graph;
	static Set<Integer> nodes;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int a, b;
		int start;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			times = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; ++i)
				times[i] = Integer.parseInt(st.nextToken());

			graph = new List[N + 1];
			for (int i = 1; i <= N; ++i) {
				graph[i] = new LinkedList<>();
			}
			
			ranks = new int[N+1];
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				graph[a].add(b);
				++ranks[b];
			}

			start = Integer.parseInt(br.readLine());
			
			cost = new int[N+1];
			solution();
			
			sb.append(cost[start] + "\n");

		}

		bw.write(sb.toString());
		bw.flush();

		bw.close();
		br.close();

	}


	private static void solution() {

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; ++i) {
			if(ranks[i] == 0) {
				cost[i] = times[i];
				q.offer(i);
			}
		}
		
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(int next : graph[cur]) {
				--ranks[next];
				cost[next] = Math.max(cost[cur] + times[next], cost[next]);
				
				if(ranks[next] == 0) {
					q.offer(next);
					
				}
			}
		}
		
	}

}