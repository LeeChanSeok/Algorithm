import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] password;
	static int passCnt;
	static String[] codes; 
	static Map<String, Integer> bacode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		bacode = new HashMap<>(8);
		bacode.put("0001101", 0); bacode.put("0011001", 1); bacode.put("0010011", 2); bacode.put("0111101", 3);
		bacode.put("0100011", 4); bacode.put("0110001", 5); bacode.put("0101111", 6); bacode.put("0111011", 7);
		bacode.put("0110111", 8); bacode.put("0001011", 9); 
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			password = new int[8];
			passCnt = 0;
			codes = new String[N];
			int res = 0;
			
			for(int i = 0; i < N; i++) {
				codes[i] = br.readLine();
			}
			
			for(int i = 0; i < N; i++) {
				if(!solution()) break;
			}
			
			int evenSum = 0;
			int oddSum = 0;
			for(int k = 0; k < 4; k++) {
				evenSum += password[k*2];
				oddSum += password[k*2+1];
			}
			int total = evenSum  + oddSum * 3;
			if(total % 10 == 0) {
				for(int num : password)
					res += num;
			}else {
				res = 0;
			}
			
			System.out.println("#" + tc + " " + res);
			
		}//tc 종료

	}
	
	private static boolean solution() {
		passCnt = 0;
		for(int i = 0; i < N; i++) {
			String code = codes[i];
			for(int j = M-1; j >= 0; --j) {
				if(code.charAt(j) == '0') continue;
				else {
					for(int k = 0; k < 8; k++) {
						String temp = code.substring(j-7*(k + 1) + 1, j-7*k+1);
						password[passCnt++] = bacode.get(temp);
					}
					return true;
				}
			}
		}
		return true;
	}
	
}