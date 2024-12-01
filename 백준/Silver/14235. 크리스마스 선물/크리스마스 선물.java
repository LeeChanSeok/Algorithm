import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 0) {
				if (pq.isEmpty())
					bw.write("-1\n");
				else
					bw.write(pq.poll() + "\n");

			} else {
				for (int j = 0; j < cmd; ++j) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}

		}

		bw.flush();

	}

}