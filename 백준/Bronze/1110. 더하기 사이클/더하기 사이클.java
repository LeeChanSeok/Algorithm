import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = Integer.parseInt(br.readLine());
		int temp = start;
		
		int cycle = 0;
		do {
			int quotient = temp / 10;
			int remainder =  temp % 10;
			
			temp = remainder * 10 + (quotient + remainder)%10;
			++cycle;
		}while(start != temp);
		
		System.out.println(cycle);
	}

}