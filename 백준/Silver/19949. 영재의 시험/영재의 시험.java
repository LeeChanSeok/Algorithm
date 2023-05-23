import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	static final int PROBLEM = 10;
	static int res;
	static int[] answer = new int[PROBLEM];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < PROBLEM; ++i) answer[i] = Integer.parseInt(st.nextToken());
		
		res = 0;
		recursive(0, 0, 1, 0);
		System.out.println(res);
		
	}
	
	private static void recursive(int idx, int prev, int cont, int corr) {
		
		if(idx == PROBLEM) {
			if(corr >= 5) ++res;
			return;
		}
		
		int match;
		for(int i = 1; i <= 5; ++i) {
			match = 0;
			if(i == answer[idx]) match = 1;
			
			if(prev == i) {
				if(cont == 2) continue;
				recursive(idx + 1, i, cont + 1, corr + match);
			}else {
				recursive(idx + 1, i, 1, corr + match);
			}
		
		}
		
	}
	
}
