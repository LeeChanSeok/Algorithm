import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Number{
		int num;
		boolean isDel;
		public Number(int num) {
			this.num = num;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N;
		char comm; int num;
		Number number;
		PriorityQueue<Number> minPQ = new PriorityQueue<>((n1, n2) -> n1.num < n2.num? -1 : 1);
		PriorityQueue<Number> maxPQ = new PriorityQueue<>((n1, n2) -> n1.num < n2.num? 1 : -1);
		for(int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			
			minPQ.clear();
			maxPQ.clear();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				comm = st.nextToken().charAt(0);
				num = Integer.parseInt(st.nextToken());
				
				if(comm == 'I') {
					number = new Number(num);
					minPQ.offer(number);
					maxPQ.offer(number);
				}
				else {
					
					if(num == 1) {
						while(!maxPQ.isEmpty()) {
							if(!maxPQ.peek().isDel) {
								maxPQ.poll().isDel = true;
								break;
							}
							maxPQ.poll();
						}
					}
					else {
						while(!minPQ.isEmpty()) {
							if(!minPQ.peek().isDel) {
								minPQ.poll().isDel = true;
								break;
							}
							minPQ.poll();
						}
					}
										
				}
			} // 입력종료
			
			while(!maxPQ.isEmpty() && maxPQ.peek().isDel) maxPQ.poll();
			
			if(maxPQ.isEmpty()) sb.append("EMPTY\n");
			else {
				sb.append(maxPQ.poll().num + " ");
				
				while(minPQ.peek().isDel) minPQ.poll();
				sb.append(minPQ.poll().num + "\n");
			}

		}
		bw.write(sb.toString());
		bw.close();
	}

}