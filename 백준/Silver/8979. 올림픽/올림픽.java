import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Nation{
		int id;
		int g, s, b;
		
		public Nation(int id, int g, int s, int b) {
			super();
			this.id = id;
			this.g = g;
			this.s = s;
			this.b = b;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Nation> pq = new PriorityQueue<>((p1, p2) -> {
			
			if(p1.g == p2.g) {
				if(p1.s == p2.s) {
					return p2.b - p1.b;
				}
				return p2.s - p1.s;
			}
			return p2.g - p1.g;
			
		}) ;
		
		Nation nation;
		int id, g, s, b;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			id = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			nation = new Nation(id, g, s, b);
			
			pq.offer(nation);
		}
		
		int rank = 1;
		Nation prev = new Nation(-1, -1, -1, -1);
		for(int i = 1; i <= N; ++i) {
			nation = pq.poll();
			
			if(!isSame(nation, prev)) {
				rank = i;
				prev = nation;
			}
			
			if(nation.id == K) {
				System.out.println(rank);
				break;
			}
		}
		
	}

	private static boolean isSame(Nation nation, Nation prev) {
		
		if(nation.g == prev.g &&
				nation.s == prev.s &&
				nation.b == prev.b)
			return true;
		
		return false;
	}

}