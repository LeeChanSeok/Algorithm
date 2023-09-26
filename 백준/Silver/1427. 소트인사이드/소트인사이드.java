import java.io.InputStreamReader;

import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int[] count = new int[10];
		for(int i = 0, len = str.length(); i < len; ++i) {
			count[str.charAt(i) - '0']++;
		}
		
		for(int i = 9; i >= 0; --i) {
			while(count[i]-- != 0) sb.append(i);
		}
		
		System.out.println(sb);

	}

}