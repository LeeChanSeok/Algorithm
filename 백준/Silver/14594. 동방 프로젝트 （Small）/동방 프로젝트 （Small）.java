import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i = 0; i <= N; ++i) {
			parent[i] = i;
		}
		
		int x, y, root;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
		
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
		
			root = findParent(x);
			for(int j = x; j <= y; ++j) parent[j] = root;
		}
		
		int answer = 0;
		
		int prev = 0;
		for(int i = 1; i <= N; ++i) {
			root = findParent(i);
			if(prev != root) {
				++answer;
				prev = root;
			}
		}
		
		System.out.println(answer);
	}

	private static int findParent(int x) {

		if(parent[x] == x) return x;
		
		parent[x] = findParent(parent[x]);
		
		return parent[x];
	}

}