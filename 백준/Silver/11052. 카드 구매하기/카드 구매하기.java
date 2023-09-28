import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) p[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j < i; ++j) {
				p[i] = Math.max(p[i], p[i-j] + p[j]); 
			}
		}
		
		System.out.println(p[n]);
	}

}