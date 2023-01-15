import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		
		String str = br.readLine();
		char c;
		boolean isTag = false;
		for(int i = 0, len = str.length(); i < len; ++i) {
			c = str.charAt(i);
			
			if(c =='>') {
				isTag = false;
				answer.append(temp.append('>').toString());
				temp = new StringBuilder();
			}else if(c == ' ') {
				if(isTag) temp.append(c);
				else {
					answer.append(temp.reverse().toString()).append(c);
					temp = new StringBuilder();
				}
			}else if(c == '<') {
				isTag = true;
				answer.append(temp.reverse().toString()).append(c);
				temp = new StringBuilder();
			}
			else {
				temp.append(c);
			}
		}
		answer.append(temp.reverse().toString()).append(" ");
		
		bw.write(answer.toString());
		bw.close();

	}

}