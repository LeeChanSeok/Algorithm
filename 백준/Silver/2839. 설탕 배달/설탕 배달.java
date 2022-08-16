import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int M,min;
	public static int[] kg = new int[] {5,3};
	
	public static void recursive(int M, int cnt, int sum) {
		if(cnt == kg.length) {
			if(M == 0) min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0, kgCnt = M/kg[cnt]; i <= kgCnt; i ++) {
			recursive(M - kg[cnt]*i, cnt+1, sum + i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		recursive(M, 0, 0);
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
				
	}

}