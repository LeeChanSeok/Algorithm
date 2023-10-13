import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] q = new int[n];
		
		int s = 0;
		int e = 0;
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			String comm = st.nextToken();
			
			if(comm.equals("push")) q[e++] = Integer.parseInt(st.nextToken());
			else if(comm.equals("pop")) {
				if(s == e) sb.append("-1\n");
				else sb.append(q[s++]).append('\n');
			}
			else if(comm.equals("size")) sb.append(e-s).append('\n');
			else if(comm.equals("empty")) {
				if(s == e) sb.append("1\n");
				else sb.append("0\n");
			}
			else if(comm.equals("front")) {
				if(s == e) sb.append("-1\n");
				else sb.append(q[s]).append('\n');
			}
			else if(comm.equals("back")) {
				if(s == e) sb.append("-1\n");
				else sb.append(q[e-1]).append('\n');
			}
		}

		System.out.println(sb);
	}

}