import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int alphaCnt = (int)('Z'-'A') + 1;
		boolean[] cambridge = new boolean[alphaCnt];
		cambridge[(int)('C'-'A')] = cambridge[(int)('A'-'A')] = cambridge[(int)('M'-'A')] = 
				cambridge[(int)('B'-'A')] =cambridge[(int)('R'-'A')] =cambridge[(int)('I'-'A')] = 
				cambridge[(int)('D'-'A')] =cambridge[(int)('G'-'A')] = cambridge[(int)('E'-'A')] = true;
		
		for(int i = 0, len = str.length(); i < len; ++i) {
			int idx = (int)(str.charAt(i) - 'A');
			if(cambridge[idx]) continue;
			sb.append(str.charAt(i));
		}
		
		System.out.println(sb.toString());

	}

}
