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

		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
		int num;
		for (int i = 0; i < N; ++i) {
			num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if(pq.size() == 0) sb.append("0\n");
				else sb.append(pq.poll() +"\n");
			} else {
				pq.offer(num);
			}
		}

		bw.write(sb.toString());
		bw.close();
	}

}