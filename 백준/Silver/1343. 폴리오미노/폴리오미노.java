import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int len = str.length();
		
		int pos = 0;
		int Xcnt = 0;
		int Acnt = 0, Bcnt = 0;
		
		while(pos < len) {
			char c = str.charAt(pos);
			if(c == '.') {
				
				if(Xcnt % 2 != 0) {
					sb = new StringBuilder();
					sb.append("-1");
					break;
				}else {
					Acnt = Xcnt / 4;
					Xcnt %= 4;
					Bcnt = Xcnt / 2;
					
					for(int i = 0; i < Acnt; ++i) sb.append("AAAA");
					for(int i = 0; i < Bcnt; ++i) sb.append("BB");
				}
				
				sb.append(".");
				Xcnt = 0;
				
			}
			else {
				++Xcnt;
			}
			
			++pos;
		}
		
		if(Xcnt % 2 != 0) {
			sb = new StringBuilder();
			sb.append("-1");			
		}else {
			Acnt = Xcnt / 4;
			Xcnt %= 4;
			Bcnt = Xcnt / 2;
			
			for(int i = 0; i < Acnt; ++i) sb.append("AAAA");
			for(int i = 0; i < Bcnt; ++i) sb.append("BB");
		}
		
		System.out.println(sb);
		
	}

}