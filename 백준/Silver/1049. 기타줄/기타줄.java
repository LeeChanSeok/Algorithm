import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int pack = 1000;
		int indi = 1000;
		
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			pack = Math.min(pack, Integer.parseInt(st.nextToken()));
			indi = Math.min(indi, Integer.parseInt(st.nextToken()));
		}
		
		int res = indi * n;
		res = Math.min(res, (((n % 6 == 0) ? n/6 : n/6 + 1) * pack));
		res = Math.min(res, ((n/6) * pack) + (n%6) * indi);
		
		System.out.println(res);
		

	}

}