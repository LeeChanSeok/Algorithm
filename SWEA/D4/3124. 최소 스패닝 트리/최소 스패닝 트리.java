import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge>{
		int a, b, c;

		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}
		
	}
	
	static int V, E;
	static int[] P;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			P = new int[V + 1];
			for(int i = 1; i < V + 1; i++)
				P[i] = i;
			
			edges = new Edge[E];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				edges[i] = new Edge(a, b, c); 
			}
			
			Arrays.sort(edges);
			int cnt = 0;
			long res = 0;
			for(Edge edge : edges) {
				if(union(edge.a, edge.b)) {
					res += edge.c;
					if(++cnt == V-1) break;
				}
			}
			
			sb.append("#" + tc + " " + res + "\n");
		}// test-case 종료
		bw.write(sb.toString());
		bw.close();
		
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		P[bRoot] = aRoot;
		return true;
	}
	
	static int find(int x) {
		if(x == P[x]) return x;
		return P[x] = find(P[x]);
	}

}