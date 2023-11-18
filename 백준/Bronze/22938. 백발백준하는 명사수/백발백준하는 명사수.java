import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int r1 = Integer.parseInt(st.nextToken());

		
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		
		double dist = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		if(dist < r1 + r2) System.out.println("YES");
		else System.out.println("NO");

	}

}