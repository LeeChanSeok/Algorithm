import java.io.*;
import java.util.*;

public class Main {
	// IO
	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb;
	static StringTokenizer st;

	// Data
	static int V, E;
	static List<Integer>[] graph;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= K; ++tc) {
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			init();

			boolean res = false;
			for(int v = 1; v <= V; ++v) {
				if(visited[v] == 0) {
					res = solution(v);
					if(!res) break;
				}
				
			}
			
			if (res) sb.append("YES\n");
			else sb.append("NO\n");

		}

		bw.write(sb.toString());
		bw.flush();

		bw.close();
		br.close();

	}
	
	private static void init() throws IOException {
		// TODO Auto-generated method stub
		graph = new ArrayList[V+1];
		visited = new int[V+1];

		for (int i = 1; i <= V; ++i) {
			graph[i] = new ArrayList<>();
		}

		int u, v;
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);

		}
		
	}
	
	private static boolean solution(int v) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {v, 1});
		visited[v] = 1;

		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int node = cur[0];
			int group = cur[1];
			
			for(int edge : graph[node]) {
				if(visited[edge] == group) return false;
				
				if(visited[edge] == 0) {
					visited[edge] = 3 - group;
					q.offer(new int[] {edge, visited[edge]});
				}
				
			}
		}
		
		return true;
	}

}