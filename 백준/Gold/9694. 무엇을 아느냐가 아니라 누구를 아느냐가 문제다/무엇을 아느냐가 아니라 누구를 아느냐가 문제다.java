import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		int u, d;

		public Edge(int u, int d) {
			super();
			this.u = u;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return this.d - o.d;
		}
		
	}
	
	static int N, M;
	static List<Edge>[] graph;
	static int[] dist, path;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; ++tc) {
			sb.append(String.format("Case #%d: ", tc));
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			graph = new List[N];
			for(int i = 0; i < N; ++i) {
				graph[i] = new LinkedList<>();
			}
			
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				graph[x].add(new Edge(y, z));
				graph[y].add(new Edge(x, z));
			}
			
			dist = new int[N];
			Arrays.fill(dist, (int)1e9);
			dist[0] = 0;
			
			path = new int[N];
			Arrays.fill(path, -1);
			path[0] = 0;
			
			dijkstra();
			
			if(dist[N-1] == (int)1e9) {
				sb.append("-1");
			} else {
				
				List<Integer> list = new ArrayList<>();
				int p = N - 1;
				while(p != 0) {
					list.add(p);
					p = path[p];
				}
				list.add(0);
				
				for(int i = list.size() - 1; i >= 0; --i) {
					sb.append(list.get(i) + " ");
				}
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);

	}

	private static void dijkstra() {

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.u] < cur.d) continue;
			
			for(Edge next : graph[cur.u]) {
				int nd = dist[cur.u] + next.d;
				if(nd < dist[next.u]) {
					dist[next.u] = nd;
					pq.offer(new Edge(next.u, nd));
					path[next.u] = cur.u; 
				}
			}
		}
	}

}