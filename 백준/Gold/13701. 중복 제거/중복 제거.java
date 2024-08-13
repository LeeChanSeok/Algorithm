import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BitSet bs = new BitSet(33554433);

		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (!bs.get(num)) {
				bw.write(num + " ");
				bs.set(num);
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}