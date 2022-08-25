import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

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
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V, E, K;
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[V+1];
		
		for(int i = 0 ; i < E; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		int[] minDist = new int[V+1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(minDist, INF);
		minDist[K] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pq.offer(new Vertex(K, 0));
		minDist[K] = 0;
		
		while(!pq.isEmpty()) {
			
			Vertex cur = pq.poll();
			if(minDist[cur.no] < cur.weight) continue;
			
			for(Node temp = adjList[cur.no]; temp != null; temp = temp.next) {
				int cost = minDist[cur.no] + temp.weight;
				if(minDist[temp.vertex] > cost) {
					minDist[temp.vertex] = cost;
					pq.offer(new Vertex(temp.vertex, cost));
				}
			}
		}
		

		for(int i = 1; i <= V; i++) {
			if(minDist[i] == INF) sb.append("INF\n");
			else sb.append(minDist[i] + "\n");
		}
		
		System.out.println(sb.toString());
	}

}