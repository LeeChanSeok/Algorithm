import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer>[] tree;
	static int[] leaf;
	static int root;
	static int del;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input();
		pro();
	}

	private static void pro() {
		
		for(int i = 0; i < N; ++i) {
			if(tree[i].contains(del)) {
				tree[i].remove(tree[i].indexOf(del));
				break;
			}
		}
		
		if(root != del)	dfs(root);
		System.out.println(leaf[root]);
	}

	private static void dfs(int node) {

		if(tree[node].isEmpty()) {
			++leaf[node];
		}
		
		for(int child : tree[node]) {
			if(child == node) continue;
			dfs(child);
			leaf[node] += leaf[child];
			
		}
		
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());		
		
		tree = new List[N];
		for(int i = 0; i < N; ++i) tree[i] = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) root = i;
			else tree[parent].add(i);
		}
				
		del = Integer.parseInt(br.readLine());
		leaf = new int[N];
		
	}

}