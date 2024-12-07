import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		
        while (N > 1) {
			N /= 2;
			res++;
		}
        
		System.out.println(res + 10);
        
	}
}