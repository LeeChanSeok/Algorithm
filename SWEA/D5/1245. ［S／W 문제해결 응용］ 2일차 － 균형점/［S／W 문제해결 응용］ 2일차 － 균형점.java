import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node implements Comparable<Node>{
		int x, m;

		@Override
		public int compareTo(Node o) {
			return this.x - o.x;
		}
	}

	static int N, nSize;
	static Node[] nodes;
	static double Err = (float) Math.pow(10, -12);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
						
			nodes = new Node[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				nodes[i] = new Node();
				nodes[i].x = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < N; i++) {
				nodes[i].m = Integer.parseInt(st.nextToken());
			}
		
			Arrays.sort(nodes);
			sb.append("#" + tc + " ");
			for(int i = 0; i < N-1; i++) {
				
				double middle = 0;
				double s, e;
				s = nodes[i].x; e = nodes[i+1].x;
				while(s < e) {
					if(Math.abs(s- e) <= Err) break;
					
					middle = (s + e) / 2;
					double L = 0, R = 0;
					
					for(Node nd : nodes) {
						if(nd.x < middle) L += Power(middle, nd.x, nd.m);
						else R += Power(middle, nd.x, nd.m);
					}
					
					if(L < R) e = middle;
					else s = middle;
				}
				sb.append(String.format("%.10f ", middle));
			}
			sb.append("\n");
			
		}//tc종료
		bw.write(sb.toString());
		bw.close();
		
	}

	private static double Power(double x1, double x2, int m) {
		return (double) (m / Math.pow(Math.abs(x1 - x2), 2));
	}
}
