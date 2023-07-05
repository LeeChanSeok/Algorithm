import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input();
		pro();
		 
	}

	private static void pro() {
		bfs(1);

		int cnt = -1;
		for(int i = 1; i <= N; ++i) if(visited[i]) ++cnt;
		
		System.out.println(cnt);
	}

	private static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		visited[start] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-- > 0) {
				int cur = q.poll();
				
				for(int next : graph[cur]) {
					if(visited[next]) continue;
					q.offer(next);
					visited[next] = true;
				}
				
			}
			if(++cnt == 2) break;
		}
		
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		for(int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited = new boolean[N+1];
	}

}