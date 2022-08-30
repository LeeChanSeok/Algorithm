import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static String str, p;
	static int pLen;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();
			
			p = br.readLine();
			str = br.readLine();
			
			pLen = p.length();
			int strPnt = pLen-1;
			int strLen = str.length();
			int ans = 0;
			while(strPnt < strLen) {
				// 패턴 비교
				int i = pLen-1;
				int j = strPnt;
				boolean isMatch = false;
				while(str.charAt(j) == p.charAt(i)) {
					i--; j--;
					if(i < 0) {
						isMatch = true;
						ans++;
						break;
					}
				}
				
				if(isMatch) {
					strPnt += pLen;
				}else {
					strPnt +=findIdx(str.charAt(strPnt), i);
				}
				
			}
			System.out.println("#" + tc + " " + ans);
		}
		

	}

	private static int findIdx(char c, int idx) {
		
		for(int i = idx; i >=0; i--) {
			if(p.charAt(i) == c) return pLen - i - 1; 
		}
		
		return pLen;
	}

}