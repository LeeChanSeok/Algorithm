import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] inOrder, postOrder, inOrderIdx;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		inOrder = new int[N+1];
		postOrder = new int[N+1];
		inOrderIdx = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) inOrder[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) postOrder[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; ++i) inOrderIdx[inOrder[i]] = i;
		
		Order(1, N, 1, N);
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();

	}
    
	private static void Order(int in_s, int in_e, int post_s, int post_e) {

		if(in_s > in_e || post_s > post_e) return;
		
		int root = postOrder[post_e];
		sb.append(root + " ");
		
		int idx = inOrderIdx[root];
		int left = idx - in_s;
		
		Order(in_s, idx - 1, post_s, post_s + left -1);
		Order(idx + 1, in_e, post_s + left, post_e - 1);
		
	}

}