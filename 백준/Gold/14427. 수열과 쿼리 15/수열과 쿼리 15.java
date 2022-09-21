import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Number implements Comparable<Number>{
		int id, num;
		boolean isDel;

		public Number(int id, int num) {
			this.id = id;
			this.num = num;
		}

		@Override
		public String toString() {
			return "(" + id + ", " + num + ", " + isDel + ")";
		}

		@Override
		public int compareTo(Number o) {
			if(this.num == o.num) return this.id < o.id ? -1 : 1;
			return this.num < o.num ? -1 : 1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		
		Number[] numbers = new Number[N+1];
		Number number;
		PriorityQueue<Number> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			number = new Number(i, Integer.parseInt(st.nextToken()));
			numbers[i] = number;
			pq.offer(number);
		}
		
		int M = Integer.parseInt(br.readLine());
		int idx, num;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().charAt(0) == '1') {
				idx = Integer.parseInt(st.nextToken());
				num = Integer.parseInt(st.nextToken());
				
				numbers[idx].isDel = true;
				number = new Number(idx, num);
				numbers[idx] = number;
				pq.offer(number);
			}else {
				while(pq.peek().isDel) pq.poll();
				sb.append(pq.peek().id).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}