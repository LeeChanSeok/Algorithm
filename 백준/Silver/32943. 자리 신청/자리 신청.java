import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Log implements Comparable<Log> {
		int T, S, N;

		public Log(int t, int s, int n) {
			super();
			T = t;
			S = s;
			N = n;
		}

		@Override
		public int compareTo(Log o) {
			// TODO Auto-generated method stub
			return this.T - o.T;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] SN = new int[X + 1];
		boolean[] isUsed = new boolean[C + 1];
		Log[] logs = new Log[K];

		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			logs[i] = new Log(t, s, n);
		}

		Arrays.sort(logs);

		for (Log log : logs) {
			if (isUsed[log.S])
				continue;

			isUsed[SN[log.N]] = false;
			SN[log.N] = log.S;
			isUsed[log.S] = true;
		}

		for (int i = 1; i <= X; ++i) {
			if (SN[i] == 0)
				continue;
			bw.write(i + " " + SN[i] + "\n");
		}

		bw.flush();
	}

}