import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int pot = 2;
		for(int i = 0; i < n; ++i) {
			pot = pot*2 - 1;
		}

		System.out.println(pot*pot);
	}

}