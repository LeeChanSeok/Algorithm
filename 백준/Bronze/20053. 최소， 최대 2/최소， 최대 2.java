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
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N, max, min, num;
		for(int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
			for(int i = 0; i < N; ++i) {
				num = Integer.parseInt(st.nextToken());
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			
			sb.append(min + " " + max + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}
