import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static class Node{
		int num;
		Node left, right;
		
		public Node(int num) {
			super();
			this.num = num;
		}

	}
	
	static Node tree;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		
		int num = Integer.parseInt(br.readLine());
		tree = new Node(num);
		
		String input = "";
		while(true) {
			input = br.readLine();
			if(input == null || input.equals("")) break;
			insertNode(Integer.parseInt(input), tree);
		}
		
		postOrder(tree);
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}
	
	private static void insertNode(int num, Node node) {

		if(num < node.num) {
			if(node.left == null) {
				node.left = new Node(num);
				return;
			}
			else {
				insertNode(num, node.left);
			}
		}else {
			if(node.right == null) {
				node.right = new Node(num);
				return;
			}
			else {
				insertNode(num, node.right);
			}
		}
		
	}
	
	private static void postOrder(Node node) {
		
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.num).append("\n");
		
	}
	
}
