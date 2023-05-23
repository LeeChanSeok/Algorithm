import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Edge{
		int e;
		long d;

		public Edge(int e, long d) {
			super();
			this.e = e;
			this.d = d;
		}
		
	}

	static List<Edge>[] graph;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		int A, B, C;
		for(int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Edge(B, C));
			graph[B].add(new Edge(A, C));
		}
		
		System.out.println(solution(N));
		
	}

	private static long solution(int N) {
		long answer = 0;
		
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		Queue<Edge> q = new LinkedList<>();
		q.offer(new Edge(1, 0));
		
		Edge cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			answer = Math.max(answer, cur.d);
			
			for(Edge next : graph[cur.e]) {
				if(visited[next.e]) continue;
				
				q.offer(new Edge(next.e, cur.d + next.d));
				visited[next.e] = true;
			}
			
		}
		
		return answer;
	}

}
