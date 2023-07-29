import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, k;
	static int[] stone;

	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		double percent = 0;
		for(int i = 1; i <= m; ++i) {
			
			double temp = 1;
			if(stone[i] < k) continue;			
			for(int j = 0; j < k; ++j) {
				temp *= (double)(stone[i] - j) / (n - j);
			}
			
			percent += temp;
		}
		
		System.out.println(percent);
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		m = Integer.parseInt(br.readLine());
		stone = new int[m+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= m; ++i) {
			stone[i] = Integer.parseInt(st.nextToken());
			n += stone[i];
		}
		
		k = Integer.parseInt(br.readLine());
		
	}

}