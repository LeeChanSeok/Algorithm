import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] attend = new int[N + 3];
		Set<Integer> sleep = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; ++i) {
			sleep.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> receive = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; ++i) {
			int num = Integer.parseInt(st.nextToken());
			if (!sleep.contains(num))
				receive.add(num);
		}

		for (int num : receive) {

			int next = num;
			for (int i = 2; next < N + 3; ++i) {
				if (!sleep.contains(next)) {
					attend[next] = 1;
				}
				next = num * i;

			}
		}

		for (int i = 1; i < N + 3; ++i) {
			attend[i] += attend[i - 1];
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			sb.append((E - S + 1) - (attend[E] - attend[S - 1])).append('\n');

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}