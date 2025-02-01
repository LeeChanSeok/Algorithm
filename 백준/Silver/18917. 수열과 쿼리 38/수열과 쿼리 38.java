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

		int M = Integer.parseInt(br.readLine());

		long sum = 0;
		long xor = 0;
		long x;

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				x = Long.parseLong(st.nextToken());
				sum += x;
				xor ^= x;
			} else if (cmd == 2) {
				x = Long.parseLong(st.nextToken());
				sum -= x;
				xor ^= x;
			} else if (cmd == 3)
				bw.write(sum + "\n");
			else if (cmd == 4)
				bw.write(xor + "\n");
		}

		bw.flush();
	}

}