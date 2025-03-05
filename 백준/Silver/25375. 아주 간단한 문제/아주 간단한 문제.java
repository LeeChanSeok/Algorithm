import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int Q = Integer.parseInt(br.readLine());
		while(Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(a * 2 <= b && b % a == 0) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb);
	}

}