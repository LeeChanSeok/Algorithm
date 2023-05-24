import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		int e, d;

		public Node(int e, int d) {
			super();
			this.e = e;
			this.d = d;
		}
		
	}
	
	static List<Node>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
		
		int p, q, r;
		for(int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			graph[p].add(new Node(q, r));
			graph[q].add(new Node(p, r));
		}
		
		visited = new boolean[N+1];
		int k, v;
		for(int i = 0; i < Q; ++i) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			sb.append(solution(k, v)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

	private static int solution(int k, int v) {
	
		Arrays.fill(visited, false);
		visited[v] = true;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(v, Integer.MAX_VALUE));
		
		Node cur;
		int answer = 0;
		int minD;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			for(Node next : graph[cur.e]) {
				minD = Math.min(cur.d, next.d);
				if(visited[next.e] || minD < k) continue;
				
				visited[next.e] = true;
				q.offer(new Node(next.e, minD));
				++answer;
			}
			
		}
		
		return answer;
	}

}