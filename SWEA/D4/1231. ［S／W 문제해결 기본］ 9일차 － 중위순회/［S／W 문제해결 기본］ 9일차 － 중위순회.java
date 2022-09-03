import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static final int T = 10;
	static int N, level, maxIdx;
	static char[] binaryTree;
	static StringBuilder sb  = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			level = (int)Math.sqrt(N);
			maxIdx = (int)Math.pow(2, level+1)+1;
			binaryTree = new char[maxIdx];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int nodeNum = Integer.parseInt(st.nextToken());
				char word = st.nextToken().charAt(0);
				
				binaryTree[nodeNum] = word;
			}
			
			sb.append("#" + tc + " ");
			inOrder(1);
			sb.append("\n");
			
		}//tc 종료

		bw.write(sb.toString());
		bw.close();
	}
	private static void inOrder(int node) {
		
		if(node > N || node >= maxIdx) return;
		
		inOrder(node * 2);
		sb.append(binaryTree[node]);
		inOrder(node * 2 + 1);
		
	}

}