import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] numArr = new int[N]; 
		for(int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sumArr = new int[N];
		sumArr[0] = numArr[0];
		for(int i = 1; i < N; i++) {
			sumArr[i] = sumArr[i-1] + numArr[i];
		}
		
		int ans = 0;
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			
			if(i == 0) ans = sumArr[j];
			else ans = sumArr[j] - sumArr[i-1];
			System.out.println(ans);
		}
	
	}
}