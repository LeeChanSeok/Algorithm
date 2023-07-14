import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int MOD = 1000000009;
	static int Q;
	static int[] Dy;
	
	public static void main(String[] args) throws Exception {
		
		input();
		pro();
	}

	private static void pro() throws Exception {
		Dy = new int[1000005];

		preprocess();
		while(Q-- > 0) {
			int x = Integer.parseInt(br.readLine());
			sb.append(Dy[x]).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void preprocess() {
		Dy[0] = 1;
		
		for(int i = 1; i <= 1000000; i++) {
			Dy[i] = Dy[i-1];
			if(i - 2 >= 0) Dy[i] += Dy[i-2];
			Dy[i] %= MOD;
			if(i - 3 >= 0) Dy[i] += Dy[i-3];
			Dy[i] %= MOD;
		}
			
	}

	private static void input() throws Exception {
		Q = Integer.parseInt(br.readLine());
	}

}