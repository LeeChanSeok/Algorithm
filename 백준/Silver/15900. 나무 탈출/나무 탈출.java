import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int total;
	static List<Integer>[] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input();
		pro();
	}

	private static void pro() {

		dfs(1, -1, 0);
		if((total & 1) == 0) System.out.println("No");
		else System.out.println("Yes");
		
	}
	
	private static void dfs(int node, int prev, int depth) {

		if(tree[node].size() == 1 && node != 1) {
			total += depth;
			return;
		}
		
		for(int next : tree[node]) {
			if(next == prev) continue;
			dfs(next, node, depth + 1);
		}
		
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		tree = new List[N+1];
		for(int i = 1; i <= N; ++i) tree[i] = new LinkedList<>();
		
		for(int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
	}

}