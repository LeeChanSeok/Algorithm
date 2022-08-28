import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] command = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine().replace("[", "").replace("]", ""), ",");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int head = 0, tail = N - 1;
			int point = 0;
			boolean isError = false;
			for (char c : command) {
				if (c == 'R')
					if (point == head)
						point = tail;
					else
						point = head;
				else {
					if (N == 0) {
						isError = true;
						sb.append("error\n");
						break;
					}

					if (point == head)
						point = ++head;
					else
						point = --tail;
					N--;
				}
			}
			if (!isError) {
				if (N == 0)
					sb.append("[]\n");
				else {
					sb.append("[");
					if (point == head) {
						while (head < tail) {
							sb.append(arr[head++] + ",");
						}
						sb.append(arr[tail]);
					} else {
						while (head < tail) {
							sb.append(arr[tail--] + ",");
						}
						sb.append(arr[head]);
					}

					sb.append("]\n");
				}
			}

		} // tc 종료
		bw.write(sb.toString());
		bw.close();

	}

}