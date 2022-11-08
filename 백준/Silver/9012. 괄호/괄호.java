import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String braket;
		while(N-- > 0) {
			braket = br.readLine();
			sb.append(isVPS(braket)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();

	}

	private static String isVPS(String braket) {

		int length = braket.length();
		int open = 0;
		
		for(int i = 0; i < length; ++i) {
			if(braket.charAt(i) == '(') ++open;
			else {
				if(open == 0) return "NO";
				--open;
			}
		}
		if(open == 0) return "YES";
		else return "NO";
	}

}