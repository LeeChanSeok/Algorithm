import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int number;
		Node next;
		
		public Node(int number, Node next) {
			super();
			this.number = number;
			this.next = next;
		}
		
	}
	
	static Node[] nodes;
	static int[] parent;		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		nodes = new Node[N+1];
		parent = new int[N+1];		
		
		for(int i = 0; i < N-1; i ++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodes[from] = new Node(to, nodes[from]);
			nodes[to] = new Node(from, nodes[to]);
		}
		
		parent[1] = 1;
		dfs(1);
		for(int i = 2; i <= N; i++)
			sb.append(parent[i] + "\n");
		
		bw.write(sb.toString());
		bw.close();
		
	}

	private static void dfs(int num) {
		
		for(Node temp = nodes[num]; temp != null; temp = temp.next ) {
			if(parent[temp.number] != 0) continue;
			parent[temp.number] = num;
			dfs(temp.number);
		}
		
	}

}