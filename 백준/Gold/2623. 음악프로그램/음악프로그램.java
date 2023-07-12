import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int v_cnt;
	static List<Integer>[] graph;
	static int[] indeg;
		
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {

		bfs();
		
		if(v_cnt  != N) System.out.println('0');
		else System.out.println(sb);
	}

	private static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; ++i) {
			if(indeg[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			++v_cnt;
			sb.append(x).append('\n');
			
			for(int y : graph[x]) {
				if(--indeg[y] == 0) q.offer(y);
			}
		}
		
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		indeg = new int[N+1];
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			
			int from = 0, to = 0;
			from = Integer.parseInt(st.nextToken());
			for(int j = 0; j < K - 1; ++j) {
				to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				++indeg[to];
				from = to;
			}
		}
		
		v_cnt = 0;
	}

}