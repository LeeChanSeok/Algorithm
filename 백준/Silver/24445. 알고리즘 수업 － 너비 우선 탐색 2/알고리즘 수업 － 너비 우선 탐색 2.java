import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r;
	static List<Integer>[] graph;
	static int[] visited;
	static int step;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		visited = new int[n + 1];

		graph = new List[n + 1];
		for (int i = 1; i <= n; ++i) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for (int i = 1; i <= n; ++i) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		step = 1;
		bfs(r);
		
        for (int i = 1; i <= n; i++) {
        	sb.append(visited[i]).append('\n');
        }
        System.out.print(sb);
	}

	private static void bfs(int r) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(r);
		visited[r] = step++;		
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : graph[cur]) {
				if(visited[next] != 0) continue;
				visited[next] = step++;
				q.offer(next);
			}
		}

	}

}