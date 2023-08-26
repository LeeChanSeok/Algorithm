import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int s = 0; int e = 0;
		
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int comm = Integer.parseInt(st.nextToken());
			if(comm == 1) {
				int num = Integer.parseInt(st.nextToken());
				arr[++e] = num;
			}else if(comm == 2) {
				if(s != e) sb.append(arr[e--]).append('\n');
				else sb.append(-1).append('\n');
			}else if(comm == 3) {
				sb.append(e - s).append('\n');
			}else if(comm == 4) {
				if(s == e) sb.append(1).append('\n');
				else sb.append(0).append('\n');
			}else if(comm == 5) {
				if(s != e) sb.append(arr[e]).append('\n');
				else sb.append(-1).append('\n');
			}
			
		}

		System.out.println(sb);
	}

}