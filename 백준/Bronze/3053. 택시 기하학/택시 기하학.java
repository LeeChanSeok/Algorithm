import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int R = Integer.parseInt(br.readLine());
		
		double res1 = R * R * Math.PI;
		double res2 = R * R * 2;
		
		System.out.printf("%.6f\n", res1);
		System.out.printf("%.6f\n", res2);

	}

}