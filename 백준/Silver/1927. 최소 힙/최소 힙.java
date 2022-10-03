import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(N);
		int command;
		for(int i = 0; i < N; ++i) {
			command = Integer.parseInt(br.readLine());
			if(command == 0) {
				if(pq.isEmpty()) sb.append(0);
				else sb.append(pq.poll());
				sb.append("\n");
			}
			else pq.add(command);
		}
		
		bw.write(sb.toString());
		bw.close();

	}

}