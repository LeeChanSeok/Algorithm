import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		Long N = Long.parseLong(br.readLine());
		if(N%2 == 1) System.out.println("SK");
		else System.out.println("CY");

	}

}