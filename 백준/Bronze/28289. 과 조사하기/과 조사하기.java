import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int P = Integer.parseInt(br.readLine());
		int[] ans = new int[4];
		for(int i = 0; i < P; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int G = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			if(G == 1) ++ans[3];
			else {
				if(C == 1 || C == 2) ++ans[0];
				else if(C == 3) ++ans[1];
				else if(C == 4) ++ans[2];
			}
		}
		
		System.out.println(ans[0] + "\n" + ans[1] + "\n"  + ans[2] + "\n" + ans[3]);

	}

}