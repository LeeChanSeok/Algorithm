import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		StringBuilder sb = new StringBuilder(S);
		
		int len = S.length();
		String[] prefix = new String[len];
		for(int i = 0; i < len; ++i) {
			prefix[i] = sb.substring(i);
		}
		
		Arrays.sort(prefix);
		
		StringBuilder answer = new StringBuilder();
		for(int i = 0; i < len; ++i) {
			answer.append(prefix[i]).append("\n");
		}

		bw.write(answer.toString());
		bw.flush();

	}

}