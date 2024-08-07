import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			String str = br.readLine();
			String first = str.split(" ")[0];
			if(first.equals("EOI")) break;
			if (str.toLowerCase().contains("nemo"))
				System.out.println("Found");
			else
				System.out.println("Missing");
		}

	}

}