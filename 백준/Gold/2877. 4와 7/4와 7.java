import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int num = N + 1;
		while(num != 1) {
			if((num & 1) == 1) sb.append("7");
			else sb.append("4");
			num = num>>1;
		}
		
		bw.write(sb.reverse().toString());
		bw.close();
		
	}

}
