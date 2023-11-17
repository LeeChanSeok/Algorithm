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
			
			double r = Double.parseDouble(st.nextToken());
			if(r == 0) break;
			
			double w = Double.parseDouble(st.nextToken());
			double l = Double.parseDouble(st.nextToken());
			
			w *= w;
			l *= l;
			
			r *= 2;
			
			sb.append("Pizza ").append(i);
			if(r >= Math.sqrt(w + l)) sb.append(" fits on the table.\n");
			else sb.append(" does not fit on the table.\n");
			
			++i;
		}
		
		System.out.println(sb);

	}

}