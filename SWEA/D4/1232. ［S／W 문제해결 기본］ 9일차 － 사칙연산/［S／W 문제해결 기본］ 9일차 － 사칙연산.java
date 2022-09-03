import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static class Node{
		String data;
		int L, R;
		public Node(String data, int l, int r) {
			super();
			this.data = data;
			L = l;
			R = r;
		}
		
	}

	static final int T = 10;
	static int N;
	static Node[] binaryTree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			binaryTree = new Node[N+1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int nodeNum = Integer.parseInt(st.nextToken());
				String word = st.nextToken();
				int L = -1, R = -1;
				if(st.hasMoreTokens()) {
					L = Integer.parseInt(st.nextToken());
					R = Integer.parseInt(st.nextToken());
				}
				binaryTree[nodeNum] = new Node(word, L, R);
			}
			
			System.out.println("#" + tc + " " + (int)inOrder(1));
			
		}//tc 종료

	}
	private static float inOrder(int num) {
		Node node = binaryTree[num];
		
		if(node.data.charAt(0) == '+') return inOrder(node.L) + inOrder(node.R);
		if(node.data.charAt(0) == '-') return inOrder(node.L) - inOrder(node.R);
		if(node.data.charAt(0) == '*') return inOrder(node.L) * inOrder(node.R);
		if(node.data.charAt(0) == '/') return inOrder(node.L) / inOrder(node.R);
		else {
			return Integer.parseInt(node.data);
		}
		
	}
}