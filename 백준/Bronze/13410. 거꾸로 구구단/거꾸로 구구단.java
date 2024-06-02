import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int max = 0;
		for(int i = 1; i <= m; ++i) {
			int res = n * i;
			sb = new StringBuilder();
			sb.append(res);
			max = Math.max(max, Integer.parseInt(sb.reverse().toString()));
		}

		System.out.println(max);
	}

}