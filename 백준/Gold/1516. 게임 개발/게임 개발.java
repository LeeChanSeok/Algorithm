import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] time, indeg, D;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		bfs();
		for(int i = 1; i <= N; ++i) sb.append(D[i]).append('\n');
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; ++i) {
			if(indeg[i] == 0) q.offer(i);
		
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int y : graph[x]) {
				D[y] = Math.max(D[y], D[x] + time[y]);
				if(--indeg[y] == 0) q.add(y);
			}
		}
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		time = new int[N+1];
		indeg = new int[N+1];
		D = new int[N+1];
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		for(int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			D[i] = time[i] = t;
			
			while(st.hasMoreTokens()) {
				int node = Integer.parseInt(st.nextToken());
				if(node == -1) break;
				graph[node].add(i);
				++indeg[i];
			}
		}
		
	}

}