import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Data{
		int order, priority;

		public Data(int order, int priority) {
			super();
			this.order = order;
			this.priority = priority;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N, M, p, idx, order;
		Data[] data;
		PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p2 - p1);
		
		for(int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			data = new Data[N];
			pq.clear();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				p = Integer.parseInt(st.nextToken());
				pq.offer(p);
				data[i] = new Data(i, p);
			}
		
			idx = order = 0;
			while(!pq.isEmpty()) {
				p = pq.poll();
				
				while(data[idx].priority != p) { idx = (idx + 1) % N; }
				++order;
				if(data[idx].order == M) {
					sb.append(order + "\n");
					break;
				}
				idx = (idx + 1) % N;
			}
			
		}
		
		bw.write(sb.toString());
		bw.close();

	}

}