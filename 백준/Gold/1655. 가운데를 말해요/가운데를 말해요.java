import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Integer> minQ = new PriorityQueue<>((p1, p2) -> p1- p2);
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((p1, p2) -> p2- p1);
		
		for(int i = 1; i <= n; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if((i&1) != 0) {
				if(maxQ.isEmpty()) maxQ.add(a);
				else {
					if(minQ.peek() < a) {
						maxQ.offer(minQ.poll());
						minQ.offer(a);
					}else maxQ.offer(a);
				}
				sb.append(maxQ.peek()).append('\n');
			}else {
				if(minQ.isEmpty()) {
					if(maxQ.peek() > a) {
						minQ.add(maxQ.poll());
						maxQ.add(a);
					}else minQ.add(a);
				}
				else {
					if(maxQ.peek() > a) {
						minQ.offer(maxQ.poll());
						maxQ.offer(a);
					}else minQ.offer(a);
				}
				sb.append(Math.min(minQ.peek(), maxQ.peek())).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}