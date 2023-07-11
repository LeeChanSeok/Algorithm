import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, v_cnt, e_cnt;
	static List<Integer>[] graph;
	static boolean[] visited;
	static boolean isTree;
	
	public static void main(String[] args) throws Exception {
		
		int tc = 0;
		while(true) {
			input();
			if(N == 0 && M == 0) break;
			pro(++tc);
		}
		System.out.println(sb);
	}

	private static void pro(int tc) {

		int ans = 0;
		
		for(int i = 1; i <= N; ++i) {
			if(visited[i]) continue;
			v_cnt = 0;
			e_cnt = 0;
			dfs(i);
			if(e_cnt == (v_cnt - 1) * 2) ++ans;
		}
		
		sb.append("Case ").append(tc).append(": ");
		if(ans == 0) sb.append("No trees.\n");
		else if(ans == 1) sb.append("There is one tree.\n");
		else sb.append("A forest of ").append(ans).append(" trees.\n");
		
	}

	private static void dfs(int node) {

		++v_cnt;
		e_cnt += graph[node].size();
		visited[node] = true;
		
		for(int next : graph[node]) {
			if(visited[next]) continue;
			dfs(next); 
		}
		
	}

	private static void input() throws Exception {

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited = new boolean[N+1];
	}

}