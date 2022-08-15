import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int k, r=6;
	public static int[] S, input, pick;
	public static StringBuffer sb = new StringBuffer();

	public static void combination(int idx, int cnt) {
		if(cnt == r) {
			for(int i : pick) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i < k; i++) {
			pick[cnt] = input[i];
			combination(i + 1, cnt + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k==0) break;
			input = new int[k];
			pick = new int[r];
			for(int i = 0; i < k; i++) input[i] = Integer.parseInt(st.nextToken());
			
			combination(0, 0);
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}