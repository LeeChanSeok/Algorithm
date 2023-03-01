import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		long[] P = new long[101];
		P[1] = P[2] = P[3] = 1;
		for(int i = 4; i <= 100; ++i) P[i] = P[i-2] + P[i-3];
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			sb.append(P[Integer.parseInt(br.readLine())]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		
	}

}