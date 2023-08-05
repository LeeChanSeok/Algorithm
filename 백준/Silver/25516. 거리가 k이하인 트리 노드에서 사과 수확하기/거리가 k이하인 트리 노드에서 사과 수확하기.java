import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, k, ans;
	static List<Integer>[] tree;
	static int[] apple;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		dfs(0, 0);
		System.out.println(ans);
	}

	private static void dfs(int x, int depth) {
		ans += apple[x];
		if(depth == k) return;
		
		for(int y : tree[x]) {
			dfs(y, depth + 1);
		}
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		tree = new List[n];
		for(int i = 0; i < n; ++i) tree[i] = new LinkedList<>();
		
		for(int i = 0; i < n - 1; ++i){
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			tree[p].add(c);
			
		}
		
		apple = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) apple[i] = Integer.parseInt(st.nextToken());
		
	}

}