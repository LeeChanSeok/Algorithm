import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		StringBuilder temp;
		String str;
		
		int N = Integer.parseInt(br.readLine());
		do {
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				temp = new StringBuilder();
				str = st.nextToken();
				sb.append(temp.append(str).reverse()).append(" ");
			}
			sb.append("\n");
		}while(--N > 0);
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

}