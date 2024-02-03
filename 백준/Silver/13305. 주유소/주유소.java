import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Gas{
		int price;
		long pos;
		
		public Gas(int price, long pos) {
			super();
			this.price = price;
			this.pos = pos;
		}

	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] len = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n - 1; ++i) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Gas> pq = new PriorityQueue<>((p1, p2) -> p1.price - p2.price);
		long pos = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			int price = Integer.parseInt(st.nextToken());
			pq.add(new Gas(price, pos));
			pos += len[i];
		}
		
		long a = pos;
		long ans = 0;
		while(a != 0) {
			Gas gas = pq.poll();
			
			if(gas.pos > a) continue;
			
			ans += (a - gas.pos) * gas.price;
			a = gas.pos;
		}
		
		System.out.println(ans);
	}

}