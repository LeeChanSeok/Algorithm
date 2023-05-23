import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String answer = "";
		if (N % 2 == 1) answer = "SK";
		else answer = "CY";

		System.out.println(answer);

	}

}