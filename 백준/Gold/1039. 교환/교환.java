import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
	static int ans;
	static int[] visited;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		int temp = n;
		while(temp != 0) {
			temp /= 10;
			++m;
		}
		
		ans = -1;
		bfs();
		
		System.out.println(ans);
	}
	
	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		
		while(!q.isEmpty() && k > 0) {
			
			int qSize = q.size();
			
			while(qSize-- > 0) {
				
				int x = q.poll();
				for(int i = 0; i < m - 1; ++i) {
					for(int j = i+1; j < m; ++j) {
						int y = swap(x, i, j);
						
						if(y == -1 || visited[y] == k) continue;
						visited[y] = k;
						q.offer(y);
						        
					}
				}
			}
			--k;
		}
		
		if(k == 0 && !q.isEmpty()) {
			for(int num : q) ans = Math.max(ans, num);
		}
		
	}

	private static int swap(int x, int i, int j) {

		char[] num = String.valueOf(x).toCharArray();
		
		if(num[j] == '0' && i == 0) return -1;
		
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
		
		return Integer.parseInt(new String(num));
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new int[1000001];

	}

}