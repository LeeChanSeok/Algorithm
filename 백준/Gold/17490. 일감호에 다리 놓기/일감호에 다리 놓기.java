import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long K;
	static int[] arr;
	static int[] link;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		link = new int[N];
		for(int i = 0; i < N; ++i) {
			link[i] = i + 1;
		}
		link[N - 1] = 0;
		
		int start = 0;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			if(x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}
			
			if(x == 0 && y == N - 1) link[y] = -1;
			else {
				link[x] = -1;
				start = y;
			}
						
		}
		
		String ans = "NO";
		if(M <= 1) ans = "YES";
		else {
			
			long total = 0;
			int end = (start - 1 + N) % N;
			
			int pos = start;
			while(true) {
				int min = arr[pos];
				while(link[pos] != -1) {
					pos = (pos + 1) % N;
					min = Math.min(arr[pos], min);
				}
				total += min;
				
				if(pos == end) break;
				pos = (pos + 1) % N;
			}
	
			if(total <= K) ans = "YES";
		}
		
		System.out.println(ans);
	}

}