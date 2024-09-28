import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; ++i) {
			int C = Integer.parseInt(br.readLine());

			if (C < N) {
				sb.append(arr[C]).append('\n');
			} else {
				sb.append(arr[(C - (V - 1)) % (N - (V - 1)) + (V - 1)]).append('\n');
			}
		}

		System.out.println(sb);
	}

}