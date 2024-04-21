import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] graph = new List[n+1];
		for(int i = 1; i <= n; ++i) {
			graph[i] = new LinkedList<>();
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
		
			if(u == -1) break;
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int[] dist = new int[n+1];	
		
		for(int i = 1; i <= n; ++i) {
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			
			boolean[] visited = new boolean[n+1];
			visited[i] = true;
			
			int cnt = -1;
			while(!q.isEmpty()) {
				
				int size = q.size();
				
				for(int j = 0; j < size; ++j) {
					int cur = q.poll();
					
					for(int next : graph[cur]) {
						if(visited[next]) continue;
						
						q.offer(next);
						visited[next] = true;
					}
				}
				++cnt;
			}
			
			dist[i] = cnt;
		}

		int score = (int)1e9;
		List<Integer> res = new LinkedList<>();
		for(int i = 1; i <= n; ++i) {
			if(dist[i] < score) {
				res.clear();
				res.add(i);
				score = dist[i];
			} else if(dist[i] == score) {
				res.add(i);
			}
		}
		
		sb.append(score + " " + res.size() + "\n");
		for(int num : res) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
		
	}

}