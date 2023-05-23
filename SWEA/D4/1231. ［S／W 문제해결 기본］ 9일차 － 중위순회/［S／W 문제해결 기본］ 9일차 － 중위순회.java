import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node{
		char c;
		int L, R;
						
		public Node(char c, int l, int r) {
			super();
			this.c = c;
			L = l;
			R = r;
		}
		
	}
	
	static Node[] graph;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/com/swea/B형특강/Day2/No1_중위순회/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		for(int tc = 1; tc <= 10; ++tc) {
			int N = Integer.parseInt(br.readLine());
			
			graph = new Node[N+1];
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				
				int L = -1, R = -1;
				if(st.hasMoreElements()) L = Integer.parseInt(st.nextToken());
				if(st.hasMoreElements()) R = Integer.parseInt(st.nextToken());
				
				graph[num] = new Node(c, L, R);
				
			}
			
			sb.append("#"  + tc + " ");
			in_order(1);
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.close();

	}

	private static void in_order(int idx) {

		if(idx == -1) return;
		
		in_order(graph[idx].L);
		sb.append(graph[idx].c);
		in_order(graph[idx].R);
		
	}

}