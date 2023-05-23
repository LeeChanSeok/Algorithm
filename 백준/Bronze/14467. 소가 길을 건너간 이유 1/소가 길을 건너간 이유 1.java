import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cows = new int[11];
		Arrays.fill(cows, -1);
		
		int pass = 0;
		int cow, side;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			cow = Integer.parseInt(st.nextToken());
			side = Integer.parseInt(st.nextToken());
			
			if((cows[cow] != -1) && (cows[cow] != side)) ++pass;
			 cows[cow] = side;
		}
		
		System.out.println(pass);
		
	}

}