import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int K, N, idx;
	static int[] visited, tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());		
		N = (int)Math.pow(2, K)-1;
		
		tree = new int[N+1];
		visited = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) visited[i] = Integer.parseInt(st.nextToken());
		inOrder(1);

		for(int i = 1; i <= K; ++i) {
			for(int s = (int)Math.pow(2, i - 1), e = (int) Math.pow(2, i); s < e; ++s) {
				sb.append(tree[s] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
	
	private static void inOrder(int node) {
		
		if(node * 2 > N) {
			tree[node] = visited[idx++];
			return;
		}
		
		inOrder(node*2);
		tree[node] = visited[idx++];
		inOrder(node*2 + 1);
		
	}

}
