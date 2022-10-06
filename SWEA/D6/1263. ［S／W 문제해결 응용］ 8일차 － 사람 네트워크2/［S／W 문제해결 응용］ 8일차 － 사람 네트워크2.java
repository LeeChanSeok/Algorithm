import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Edge{
		int vertex, dist;

		public Edge(int vertex, int dist) {
			super();
			this.vertex = vertex;
			this.dist = dist;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N, edge, result, min, next, cost;
		Edge cur;
		int INF = Integer.MAX_VALUE;
		List<Integer>[] graph;
		int[] minEdge;
		boolean[] visit;
		ListIterator<Integer> iter;
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.dist - e2.dist);
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			// 인접 리스트로 graph 구현
			graph = new LinkedList[N+1];
			for(int i = 1; i <= N; ++i) graph[i] = new LinkedList<>();
			
			for(int i = 1; i <= N; ++i) {
				for(int j = 1; j <= N; ++j) {
					edge = Integer.parseInt(st.nextToken());
					if(edge == 1) graph[i].add(j);
				}
			}

			minEdge = new int[N+1];
			visit = new boolean[N+1];
			
			min = INF;
			// 모든 노드에 대해서 다잌스트라를 이용해 각 노드에서의 최소 이동 거리 구하기
			for(int i = 1; i <= N; ++i) {
				
				pq.clear();
				Arrays.fill(minEdge, INF);
				Arrays.fill(visit, false);
				
				pq.add(new Edge(i, 0));
				minEdge[i] = 0;
				
				// i번째 노드에 대해서 다잌스트라를 이용해 최단 경로 구하기
				while(!pq.isEmpty()) {
					cur = pq.poll();
					
					if(minEdge[cur.vertex] < cur.dist) continue;
					
					iter = graph[cur.vertex].listIterator();
					while(iter.hasNext()) {
						next = (int)iter.next();
												
						cost = minEdge[cur.vertex] + 1;
						if(cost < minEdge[next]) {
							minEdge[next] = cost;
							pq.add(new Edge(next, cost));
						}
						
					}
					
				}
				
				
				result = 0;
				for(int j = 1; j <= N; ++j) {
					if(i == j) continue;
					result += minEdge[j];
				}
				
				min = Math.min(result, min);
			}
			
			System.out.printf("#%d %d\n", tc, min);
		} // tc 종료
	}

}