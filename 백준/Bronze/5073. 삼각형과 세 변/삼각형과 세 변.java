import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			String res = "";
			int[] r = new int[3];
			r[0] = Integer.parseInt(st.nextToken());
			r[1] = Integer.parseInt(st.nextToken());
			r[2] = Integer.parseInt(st.nextToken());
			
			if(r[0] == 0) break;
			
			Arrays.sort(r);
			
			if(r[0] == r[1] && r[1] == r[2]) res = "Equilateral";
			else if(r[2] >= r[0] + r[1]) res = "Invalid";
			else if(r[0] == r[1] || r[1] == r[2] || r[0] == r[2]) res = "Isosceles";
			else res = "Scalene";
			
			sb.append(res).append('\n');
		}

		System.out.println(sb);
	}

}