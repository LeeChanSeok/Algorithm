import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int prev = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());

			int diff = num - min;

			if (diff > prev) {
				prev = diff;
				bw.write(diff + " ");
			} else {
				bw.write(prev + " ");
			}
			min = Math.min(min, num);
		}

		bw.flush();
		bw.close();

	}

}