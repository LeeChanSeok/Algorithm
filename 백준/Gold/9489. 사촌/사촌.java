import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int[] a, parent;
	
	public static void main(String[] args) throws IOException {

		while(true) {
			if(input()) break;
			
			pro();
		}

	}

	private static void pro() throws IOException {

		parent[0] = -1;
		parent[1] = 0;
		
		int last = 1;
		for(int i = 2; i <= N; i++, last++) {
			for(; i <= N; ++i) {
				parent[i] = last;
				if(i < N && a[i] + 1 != a[i+1]) {
					break;
				}
			}
		}
		
        int kIdx = 0;
        for (int i = 1; i <= N; i++) if (a[i] == K) kIdx = i;
        int ans = 0;
        for (int i = 1; i <= N; i++)
            if (parent[parent[i]] == parent[parent[kIdx]] && parent[i] != parent[kIdx])
                ans++;

        System.out.println(ans);
	}
	
	private static boolean input() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N == 0 && K == 0) return true;;
		
		a = new int[N+1];
		parent = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) a[i] = Integer.parseInt(st.nextToken());
		
		return false;
	}

}