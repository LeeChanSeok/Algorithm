import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static class Data{
		long num;
		String op = "";
		
		public Data(long num, String op) {
			super();
			this.num = num;
			this.op = op;
		}
		
	}
	
	static long DELTA = 1000000000;
	static long s, t;
	static Set<Long> visited;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		String ans = "-1";
		if(s == t) ans = "0";
		else ans = bfs();
		
		System.out.println(ans);
	}

	private static String bfs() {

		Queue<Data> q = new LinkedList<>();
		q.offer(new Data(s, ""));
		
		visited = new HashSet<>();
		visited.add(s);
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			while(qSize-- > 0) {
				Data cur = q.poll();
				
				if(cur.num == t) return cur.op;
				
				long num;
				// 1. '*'
				num = cur.num * cur.num;
				if(0 < num && num <= DELTA && !visited.contains(num)) {
					
					visited.add(num);
					q.offer(new Data((int)num, cur.op + "*")); 
				}
				
				// 2. '+'
				num = cur.num + cur.num;
				if(num <= DELTA && !visited.contains(num)) {
					visited.add(num);
					q.offer(new Data((int)num, cur.op + "+"));
				}
				
				// 3. '/'
				if(cur.num != 0 && !visited.contains(1l)) {
					visited.add(1l);
					q.offer(new Data(1, cur.op + "/"));
				}
			}
		}
		
		return "-1";
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Long.parseLong(st.nextToken());
		t = Long.parseLong(st.nextToken());
		
	}

}