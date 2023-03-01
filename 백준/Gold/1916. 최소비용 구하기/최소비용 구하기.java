import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, start, end;
	static List[] graph;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new List[N+1];
		for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<int[]>();
		
		dist = new int[N+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		int f, t, d;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			graph[f].add(new int[] {t, d});
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int answer = bfs();
		System.out.println(answer);
		
	}

	private static int bfs() {

		dist[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		pq.add(new int[] {start, 0});
		
		int d;
		List<int[]> list;
		int[] cur;
		while(!pq.isEmpty()) {

			cur = pq.poll();
			if(cur[0] == end) return cur[1];
			
			list = graph[cur[0]];
			
			for(int[] edge : list) {
				d = cur[1] + edge[1];
				if(dist[edge[0]] > d) {
					dist[edge[0]] = d;
					pq.offer(new int[] {edge[0], d});
				}
			}
		}
		
		return -1;
	}

}