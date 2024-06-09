import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] cnt;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n % 2 == 0) {
			int x = n / 2;
			while(x-- > 0) bw.write("1");
		} else {
			int x = (n - 3) / 2;
			bw.write("7");
			while(x-- > 0) bw.write("1");
		}
		
		bw.flush();
		bw.close();
	}

}