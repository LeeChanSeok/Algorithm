import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int m;
	static int DELTA = 1000000;
	static int[] cntArr;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() throws Exception{

		StringTokenizer st = new StringTokenizer(br.readLine());
		while((st.hasMoreTokens())) {
			double temp = Double.parseDouble(st.nextToken());
			temp += 1e-9;
			++cntArr[m * (int)(temp * DELTA)/DELTA];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int cnt : cntArr) sb.append(cnt).append(' ');
		System.out.println(sb);
	}

	private static void input() throws Exception{

		m = Integer.parseInt(br.readLine());
		cntArr = new int[m];
		
	}

}