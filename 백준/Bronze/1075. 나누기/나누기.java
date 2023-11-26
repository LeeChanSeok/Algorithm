import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		N = (N/100)*100;
		
		for(int i = 0; i < 100; ++i, ++N) {
			
			if(N % F == 0) {
				String strN = String.valueOf(N);
				int len = strN.length();
				System.out.println(strN.substring(len-2, len));
				break;
			}
			
		}

	}

}