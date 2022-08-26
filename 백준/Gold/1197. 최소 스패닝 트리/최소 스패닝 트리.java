import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	static class Vertex {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	}

	static int V, E;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.weight, v2.weight));
		
		int[] minEdge = new int[V+1];
		Arrays.fill(minEdge, INF);
		
		boolean[] visited = new boolean[V+1];
		
		pq.offer(new Vertex(1, 0));
		
		int cnt = 0;
		int res = 0;
		while(true) {
			
			Vertex cur = pq.poll();
			if(visited[cur.no] || minEdge[cur.no] < cur.weight) continue;
			
			visited[cur.no]= true;
			res += cur.weight;
			
			if(++cnt == V) break;
			
			for(Node temp = adjList[cur.no]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pq.offer(new Vertex(temp.vertex, temp.weight));
				}
			}
			
		}
		
		System.out.println(res);

	}

}