import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Node{
		int x, y;
	}
	
	static class Vertex{
		int v;
		double dist;

		public Vertex(int v, double dist) {
			super();
			this.v = v;
			this.dist = dist;
		}
		
	}
	
	static int N;
	static int INF = Integer.MAX_VALUE;
	static double E;
	static Node[] nodes;
	static double[][] distArr;
	static PriorityQueue<Vertex> pq;
	static double[] minVertex;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			nodes = new Node[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				nodes[i] = new Node();
				nodes[i].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());			
			for(int i = 0; i < N; i++) {
				nodes[i].y = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			distArr = new double[N][N];
			for(int i = 0; i < N-1; i++) {
				distArr[i][i] = INF;
				for(int j = i+1; j < N; j++) {
					distArr[i][j] = distArr[j][i] = calc_dist(nodes[i], nodes[j]);
				}
			}
			
			minVertex = new double[N];
			visit = new boolean[N];
			Arrays.fill(minVertex, INF);
			long ans = (long)(Math.round(prim() * E));
			System.out.println("#" + tc + " " + ans);
			
			
		}//tc종료
			
	}

	private static double prim() {
		double L = .0;
		
		pq = new PriorityQueue<>((v1, v2) -> Double.compare(v1.dist, v2.dist));
		pq.offer(new Vertex(0, 0));
		int pick = 0;
		minVertex[0] = 0;
		while(true) {
			Vertex cur = pq.poll();
			
			if(cur.dist > minVertex[cur.v]) continue;
			visit[cur.v] = true;
			L += minVertex[cur.v] * minVertex[cur.v];
			pick++;
			
			if(pick == N) break;
			
			for(int i = 0; i < N; i++) {
				if(!visit[i] && distArr[cur.v][i] < minVertex[i]) {
					minVertex[i] = distArr[cur.v][i];
					pq.add(new Vertex(i, minVertex[i]));
				}
			}
			
		}
		
		return L;
	}

	private static double calc_dist(Node n1, Node n2) {
		double a = Math.abs(n1.x - n2.x);
		double b = Math.abs(n1.y - n2.y);
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return c;
	}

}