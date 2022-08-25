import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex{
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
	
			Node[] adjList = new Node[V+1];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				
				adjList[from] = new Node(to, weight, adjList[from]);
				adjList[to] = new Node(from, weight, adjList[to]);
				
			}
			
			int[] minEdge = new int[V+1];
			boolean[] visited = new boolean[V+1];
			
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[1] = 0;
			long res = 0;

			
			PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.weight, v2.weight));
			pq.offer(new Vertex(1, 0));
			
			int cnt = 0;
			while(true) {
				Vertex cur = pq.poll();
				if(visited[cur.no]) continue;
				
				visited[cur.no] = true;
				res += cur.weight;

				if(++cnt == V) break;
				
				for(Node temp = adjList[cur.no]; temp != null; temp = temp.next ) {
					if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
						minEdge[temp.vertex] = temp.weight;
						pq.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
						
					}
				}
				
			}
			
			sb.append("#" + tc + " " + res + "\n");
		} // test-case 종료
		bw.write(sb.toString());
		bw.close();

	}

}