import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static Set<Integer>[] graph;
	static int a, b;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		
		M = Integer.parseInt(st.nextToken());
		
		graph = new HashSet[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new HashSet<>();
		
		int x, y;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		System.out.println(solution());
	}

	private static int solution() {
		int answer = -1;
		
		boolean[] visited = new boolean[N+1];
		visited[a] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		
		int qSize, cur;
		int step = 0;
		while(!q.isEmpty()) {
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				if(cur == b) return step;

				for(int next : graph[cur]) {
					if(visited[next]) continue;
					
					q.offer(next);
					visited[next] = true;
				}

			}
			++step;
		}
		
		return answer;
	}

}
