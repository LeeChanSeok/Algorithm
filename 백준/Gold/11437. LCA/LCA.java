import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static Node[] tree;
	static int[] parent, level;
	
	static class Node {
		List<Integer> child;

		public Node() {
			 child = new LinkedList<>();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
				
		tree = new Node[n+1];
		for(int i = 1; i <= n; ++i) {
			tree[i] = new Node();
		}
		
		for(int i = 0; i < n - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			tree[u].child.add(v);
			tree[v].child.add(u);
					
		}
		
		parent = new int[n+1];
		level = new int[n+1];
		
		bfs();
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			

			while(level[u] != level[v]) {
				if(level[u] > level[v]) u = parent[u];
				else v = parent[v];
			}
					
			
			while(u != v) {
				u = parent[u];
				v = parent[v];
			}
			
			sb.append(u).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		
		q.offer(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int child : tree[node].child) {
				if(visited[child]) continue;
				
				parent[child] = node;
				level[child] += level[node] + 1;
				q.offer(child);
				
				visited[child] = true;
			}
		}
		
	}

}