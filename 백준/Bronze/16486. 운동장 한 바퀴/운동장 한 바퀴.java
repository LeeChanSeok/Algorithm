import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());
		
		int C = d1 * 2;
		double AB = 2 * 3.141592 * d2;
		
		System.out.println(AB + C);
		
	}

}