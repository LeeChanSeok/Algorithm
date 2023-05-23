import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isAttend = new boolean[31];
		
		for(int i = 0; i < 28; ++i) {
			isAttend[Integer.parseInt(br.readLine())] = true;
		}
		
		for(int i = 1; i <= 30; ++i) {
			if(!isAttend[i]) sb.append(i + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}