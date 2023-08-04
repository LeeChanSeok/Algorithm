import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m, k, size;
	
	static long[] num;
	static long[] tree;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() throws Exception{
		init(1, n, 1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= m + k; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long diff = c - num[b];
				num[b] = c;
				update(1, n, 1, b, diff);
			}else {
				sb.append(sum(1, n, 1, b, (int)c)).append('\n');
			}
		}
		
		System.out.println(sb);
	}

	private static long sum(int start, int end, int node, int left, int right) {

		if(left > end || right < start) return 0;
		
		if(left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;

		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	private static void update(int start, int end, int node, int idx, long diff) {
		
		if( idx < start || idx > end) return;
		
		tree[node] += diff;
		if(start == end) return;
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, diff);
		update(mid + 1, end, node * 2 + 1, idx, diff);
		
	}

	private static long init(int start, int end, int node) {

		if(start == end) return tree[node] = num[start];
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		
	}

	private static void input() throws Exception{

		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		num = new long[n + 1];
		for(int i = 1; i <= n; ++i) num[i] = Long.parseLong(br.readLine());

//		int K = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
//		size = (int) Math.pow(K, 2);
//		
//		tree = new long[size];
		
		tree = new long[n * 4];
	}

}