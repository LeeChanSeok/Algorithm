import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static class Info{
		int y, v;

		public Info(int y, int v) {
			super();
			this.y = y;
			this.v = v;
		}
		
	}
	
	static int N, M;
	static int[] indeg;
	static int[][] cnt;
	static List<Info>[] graph;
	static TreeMap<Integer, Integer> ans = new TreeMap<>();
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; ++i) {
			if(indeg[i] == 0) {
				q.offer(i);
				cnt[i][i] = 1;
			}
		}
		
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(Info info : graph[x]) {
				int y = info.y, v = info.v; 
				
				for(int i =1; i <= N; ++i) {
					cnt[y][i] += cnt[x][i] * v;
				}
				
				if(--indeg[y] == 0) q.offer(y);
			}
			
		}
		
		for(int i = 1; i <= N; ++i) {
			if(cnt[i][i] == 1) sb.append(i).append(' ').append(cnt[N][i]).append('\n');
		}
		
		System.out.println(sb);
		
	}

	private static void input() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		indeg = new int[N+1];
		for(int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			graph[Y].add(new Info(X, K));
			++indeg[X];
		}
		
		cnt = new int[N+1][N+1];
	}
}
