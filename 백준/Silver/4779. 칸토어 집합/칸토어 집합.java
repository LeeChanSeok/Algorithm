import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int n;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		while((str = br.readLine()) != null) {
			sb = new StringBuilder();
			n = Integer.parseInt(str);
			
			int len = (int) Math.pow(3, n);
			for (int i = 0; i < len; i++) {
				sb.append("-");
			}
			
			recursive(0, len);
			
			sb.append('\n');
			bw.write(sb.toString());
			bw.flush();
		}
	}

	private static void recursive(int start, int size) {

		if(size == 1) {
			return;
		}

		int nSize = size/3;
		
		for(int i=start+nSize; i<start+2*nSize; i++) {
			sb.setCharAt(i, ' ');
		}
		
		recursive(start, nSize);
		recursive(start+2*nSize, nSize);
		
	}

}