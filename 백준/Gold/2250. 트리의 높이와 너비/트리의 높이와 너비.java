import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int l, r;

		public Node(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}
		
	}

	static Node[] tree;
	static int n;
	static int col;
	static int[][] grid;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		boolean[] isRoot = new boolean[n+1];
		tree = new Node[n+1];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int id = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			tree[id] = new Node(l, r);
			
			if(l != -1)	isRoot[l] = true;
			if(r != -1)	isRoot[r] = true;
		}
		
		int root = 0;
		for(int i = 1; i <= n; ++i) {
			if(!isRoot[i]) {
				root = i;
				break;
			}
		}
		
		grid = new int[n+1][2];
		for(int i = 1; i <= n; ++i) {
			grid[i][0] = 10000;
			grid[i][1] = 0;
		}
		
		col = 0;
		inOrder(root, 1);
		
		int[] ans = new int[] {n, 0};
		for(int i = 1; i <= n; ++i) {
			int diff = grid[i][1] - grid[i][0] + 1;
			if(diff > ans[1]) {
				ans = new int[] {i, diff};
				ans[1] = diff;
			}
		}
		
		System.out.println(ans[0] + " " + ans[1]);
	}

	private static void inOrder(int node, int level) {

		if(node == -1) return;
		
		inOrder(tree[node].l, level + 1);
		update(node, level);
		inOrder(tree[node].r, level + 1);
		
	}

	private static void update(int node, int level) {
		++col;
		if(grid[level][0] > col) grid[level][0] = col;
		if(grid[level][1] < col) grid[level][1] = col;
		
	}

}