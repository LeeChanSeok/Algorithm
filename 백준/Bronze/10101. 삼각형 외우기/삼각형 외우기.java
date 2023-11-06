import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] angle = new int[3];
		for(int i = 0; i < 3; ++i) angle[i] = Integer.parseInt(br.readLine());
		
		int totla = angle[0] + angle[1] + angle[2];
		String res = "";
		
		if(angle[0] == 60 && angle[1] == 60 && angle[2] == 60) res = "Equilateral";
		else if(totla == 180) {
			if(angle[0] == angle[1] || angle[1] == angle[2] || angle[0] == angle[2]) res = "Isosceles";
			else res = "Scalene";
		}
		else res = "Error";

		System.out.println(res);
	}

}