import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int k;
	static int x1, y1, x2, y2;
	static int sx,sy,dx,dy;
	static int[][] bus;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= k; ++i) {
			int x1 = bus[i][0];	int y1 = bus[i][1];	int x2 = bus[i][2];	int y2 = bus[i][3];
			if(sx >= x1 && sx <= x2 && sy >= y1 && sy <= y2) {
				q.offer(i);
				visited[i] = true;
			}
		}
		
		int res = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			while(qSize-- > 0) {
				
				int b = q.poll();
				if(isArrive(b)) return res;
				
				for(int i = 1; i <= k; ++i) {
					if(visited[i]) continue;
					
					if(isCorss(b, i)) {
						q.offer(i);
						visited[i] = true;
					}
				}
				
			}
					
			++res;
		}
		
		return 0;
	}

	private static boolean isCorss(int from, int to) {
		
		int fx1 = bus[from][0];	int fy1 = bus[from][1];	int fx2 = bus[from][2];	int fy2 = bus[from][3];
		int tx1 = bus[to][0];	int ty1 = bus[to][1];	int tx2 = bus[to][2];	int ty2 = bus[to][3];
		
		if(fx2 >= tx1 && tx2 >= fx1 && fy2 >= ty1 && fy1 <= ty2) return true;
		return false;
	}

	private static boolean isArrive(int b) {

		int x1 = bus[b][0];	int y1 = bus[b][1];	int x2 = bus[b][2];	int y2 = bus[b][3];
		if(dx >= x1 && dx <= x2 && dy >= y1 && dy <= y2) return true;
		return false;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(br.readLine());
		bus = new int[k+1][4];
		for(int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int h = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			if(y1 > y2) swapY();
			if(x1 > x2) swapX();
			
			bus[h] = new int[] {x1, y1, x2, y2};
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		dx = Integer.parseInt(st.nextToken());
		dy = Integer.parseInt(st.nextToken());
		
		visited = new boolean[k+1];
	}

	private static void swapY() {
		int y;	y = y1; y1 = y2; y2 = y;
	}
	private static void swapX() {
		int x;	x = x1; x1 = x2; x2 = x;
	}

}