import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int i = 1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0) break;
			if(i != 1)sb.append("\n");
			sb.append("Triangle #").append(i).append('\n');
			
			if(a == -1) {
				int len = c * c - b * b;
				if(c <= b) sb.append("Impossible.\n");
				else sb.append("a = ").append(String.format("%.3f", Math.sqrt(len))).append('\n');
			}else if(b == -1) {
				int len = c * c - a * a;
				if(c <= a) sb.append("Impossible.\n");
				else sb.append("b = ").append(String.format("%.3f", Math.sqrt(len))).append('\n');
			}else {
				int len = a * a + b * b;
				sb.append("c = ").append(String.format("%.3f", Math.sqrt(len))).append('\n');
			}
			
			++i;
		}
		
		System.out.println(sb);

	}

}