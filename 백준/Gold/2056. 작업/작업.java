import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer>[] graph;
	static int[] indeg, T, T_Done;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {
		
		bfs();
		
		int ans = 0;
		for(int i = 1; i <= N; ++i) ans = Math.max(ans, T_Done[i]);
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; ++i) {
			if(indeg[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int y : graph[x]) {
				T_Done[y] = Math.max(T_Done[y], T_Done[x] + T[y]);
				if(--indeg[y] == 0) q.offer(y);
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		indeg = new int[N+1];
		T = new int[N+1];
		T_Done = new int[N+1];
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		for(int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			T[i] = T_Done[i] = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; ++j) {
				int y = Integer.parseInt(st.nextToken());
				
				graph[y].add(i);
				++indeg[i];
			}
		}
		
	}

}
