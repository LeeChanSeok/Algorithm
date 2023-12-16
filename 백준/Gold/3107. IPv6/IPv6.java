import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = 8;
		
		String[] ipv6 = new String[n];
		String str = br.readLine();
		String[] input = str.split(":");

		
		// 8 - 3 + 2
		for(int i = 0; i < input.length; ++i) {
			if(input[i].equals("")) {
				int cnt = n - input.length + 1;
				if(i == 0) {
					++cnt;
					++i;
				}
				for(int j = 0; j < cnt; ++j) sb.append("0000:");
				
			}else {
				String ip = input[i];
				int cnt = 4 - ip.length();
				for(int j = 0; j < cnt; ++j) ip = "0" + ip;
				
				sb.append(ip).append(":");
			}
		}
		
		if(str.charAt(str.length()-1) == ':') {
			for(int i = input.length; i < n; ++i) sb.append("0000:");
		}
			
		sb.delete(sb.length()-1, sb.length());

		System.out.println(sb);
	}

}