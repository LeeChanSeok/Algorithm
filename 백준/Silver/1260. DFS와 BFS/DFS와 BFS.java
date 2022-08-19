import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V;
	static int S, E;
	static List[] graph;
	static boolean[] visit;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i = 1; i < N+1; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph[S].add(E);
			graph[E].add(S);
		}
		
		for(int i = 1; i < N+1; i++)
			Collections.sort(graph[i]);
		
		visit = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs(V);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int num) {
		visit[num] = true;
		sb.append(num).append(" ");
		
		List nodes = graph[num];
		if(nodes == null) return;
		for(int i = 0, nSize = nodes.size(); i < nSize; i++) {
			int nextNode = (int)nodes.get(i);
			if(!visit[nextNode]) dfs(nextNode);
		}
	}
	
	public static void bfs(int num) {
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(num);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			visit[node] = true;
			sb.append(node).append(" ");
			
			List nodes = graph[node];
			
			if(nodes == null) continue;
			for(int i = 0, nSize = nodes.size(); i < nSize; i++) {
				int nextNode = (int)nodes.get(i);
				if(!visit[nextNode]) {
					visit[nextNode] = true;
					q.add(nextNode);
				}
			}
		}
	}

}