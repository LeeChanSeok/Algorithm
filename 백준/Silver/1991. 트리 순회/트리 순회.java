import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] Tree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		Tree = new int[27][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int node = st.nextToken().charAt(0) - 'A' + 1;
			int L = st.nextToken().charAt(0);
			int R = st.nextToken().charAt(0);

			if (L != '.')
				Tree[node][0] = L - 'A' + 1;
			if (R != '.')
				Tree[node][1] = R - 'A' + 1;
		}

		preorder_traversal(1);
		sb.append("\n");
		inorder_traversal(1);
		sb.append("\n");
		postorder_traversal(1);
		sb.append("\n");

		bw.write(sb.toString());
		bw.close();
	}

	private static void postorder_traversal(int node) {
		if (node == 0)
			return;

		postorder_traversal(Tree[node][0]);
		postorder_traversal(Tree[node][1]);
		sb.append((char) (node - 1 + 'A'));

	}

	private static void inorder_traversal(int node) {
		if (node == 0)
			return;

		inorder_traversal(Tree[node][0]);
		sb.append((char) (node - 1 + 'A'));
		inorder_traversal(Tree[node][1]);

	}

	private static void preorder_traversal(int node) {
		if (node == 0)
			return;

		sb.append((char) (node - 1 + 'A'));
		preorder_traversal(Tree[node][0]);
		preorder_traversal(Tree[node][1]);

	}

}