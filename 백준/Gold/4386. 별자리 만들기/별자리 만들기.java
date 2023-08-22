import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge{
		int node;
		double dist;
		
		public Edge(int node, double dist) {
			super();
			this.node = node;
			this.dist = dist;
		}
		
	}
	
	static int n;
	static double[][] adjMatrix;
	static double[][] point;
	static PriorityQueue<Edge> pq;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		
		pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1.dist, e2.dist));
		visited = new boolean[n+1];
		
		double ans = prim();
		
		System.out.printf("%.2f",ans);
		
	}

	private static double prim() {

		pq.offer(new Edge(1, 0));
		
		double ans = 0;
		int cnt = 0;
		while(!pq.isEmpty() && cnt != n) {
			
			Edge cur = pq.poll();
			int x = cur.node;
			double dist = cur.dist;
			if(visited[x]) continue;
			visited[x] = true;
			
			ans += dist;
			
			for(int y = 1; y <= n; ++y) {
				if(visited[y]) continue;
				pq.offer(new Edge(y, adjMatrix[x][y]));
			}
			
			++cnt;
		}
		
		return ans;
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		point = new double[n+1][2];
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Double.parseDouble(st.nextToken());
			point[i][1] = Double.parseDouble(st.nextToken());
		}
		
		adjMatrix = new double[n+1][n+1];
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				adjMatrix[i][j] = Math.sqrt(Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2));
			}
		}
		
	}

}