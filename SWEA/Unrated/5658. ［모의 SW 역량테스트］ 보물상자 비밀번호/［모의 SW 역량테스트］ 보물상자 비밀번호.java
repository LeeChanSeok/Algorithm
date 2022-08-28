import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;
	static char[] number;
	static String[] pws;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		
			number = br.readLine().toCharArray();
			sb.append("#" + tc + " " + simulation() + "\n");
			
		}// tc 종료
		bw.write(sb.toString());
		bw.close();
	}

	private static int simulation() {
		pws = new String[N];
		Arrays.fill(pws, "000");
		int pw_cnt = 0;
		int length = N/4;
		
		StringBuilder temp;
		for(int start = 0; start < length; start++) {
			
			temp = new StringBuilder();
			int point = start;
			for(int cnt = 1; cnt <= N; cnt++) {
				temp.append(number[point]);
				if(cnt % length == 0) {
					String str = temp.toString();
					if(!DupCheck(str, pw_cnt)) pws[pw_cnt++] = str;
					temp = new StringBuilder();
				}
				
				if(++point >= N) point %= N;
			}
		}
		
		Arrays.sort(pws, (pw1, pw2) -> pw2.compareTo(pw1));

		return HexToDec(pws[K-1]);
		
	}
	private static boolean DupCheck(String str, int pw_cnt) {
		
		for(int i = 0; i < pw_cnt; i++) {
			if(pws[i].compareTo(str) == 0) return true;
		}
		return false;
	}
	
	private static int HexToDec(String num) {
		int res = 0;
		for(int i = 0, len = N/4; i < len; i++) {
			char Hex = num.charAt(i);
			if(Hex >= '0' && Hex <= '9') res += (Hex - '0') * Math.pow(16, len-1-i);  
			else res += (Hex - 'A' + 10) * Math.pow(16, len-1-i);
		}
		return res;
	}

}