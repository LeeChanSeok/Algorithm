import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, a, b;
	static int[] stones;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		stones = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) stones[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int answer;
		if(a == b) answer = 0;
		else answer = bfs(N, a, b);
		
		System.out.println(answer);
	}

	private static int bfs(int N, int a, int b) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
		pq.add(new int[] {a, 0});
		
		boolean[] visited = new boolean[N+1];
		visited[a] = true;
		
		int[] cur;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(cur[0] == b) return cur[1];
			
			int idx = 0;
			int next;
			// 1. 증가
			while(true) {
				++idx;
				next = cur[0] + stones[cur[0]] * idx;
				if(next > N) break;
				
				if(visited[next]) continue;
				
				visited[next] = true;
				pq.add(new int[] {next, cur[1] + 1});
			
			}
			
			idx = 0;
			// 2. 감소
			while(true) {
				++idx;
				next = cur[0] - stones[cur[0]] * idx;
				if(next < 1) break;
				
				if(visited[next]) continue;
				
				visited[next] = true;
				pq.add(new int[] {next, cur[1] + 1});
			
			}

		}
		
		return -1;
	}

}
