import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		if(A > B) {
			long temp = A;
			A = B;
			B = temp;
		}
		
		int cnt = 0;
		for(long i = A + 1; i < B; ++i) {
			++cnt;
			sb.append(i + " ");
		}
		
		System.out.println(cnt);
		System.out.println(sb);

	}

}