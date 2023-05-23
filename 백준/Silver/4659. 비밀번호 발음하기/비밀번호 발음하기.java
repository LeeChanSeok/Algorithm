import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static boolean[] vowel;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		vowel = new boolean[(int)('z' - 'a' +1)];
		init_vowel();
		String str = "";
		while(!(str = br.readLine()).equals("end")) {
			if(check(str)) {
				sb.append(Password(str, true));
			}else{
				sb.append(Password(str, false));
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}

	private static void init_vowel() {
		vowel[(int)('a' - 'a')] = true;
		vowel[(int)('e' - 'a')] = true;
		vowel[(int)('i' - 'a')] = true;
		vowel[(int)('o' - 'a')] = true;
		vowel[(int)('u' - 'a')] = true;
		
	}

	private static boolean check(String str) {
		
		if(!check1(str)) return false;
		if(!check2(str)) return false;
		if(!check3(str)) return false;
		
		return true;
	}

	private static boolean check3(String str) {
		
		char prev = str.charAt(0);
		char cur;
		for(int i = 1, len = str.length(); i < len; ++i) {
			cur = str.charAt(i);
			
			if(prev == cur) {
				if(cur != 'e' && cur != 'o') return false;
			}
			
			prev = cur;
		}
		
		return true;
	}

	private static boolean check2(String str) {
		int conCnt = 0, vowCnt = 0;
		
		for(int i = 0, len = str.length(); i < len; ++i) {
			if(vowel[(int)(str.charAt(i) - 'a')]) {
				conCnt = 0;
				++vowCnt;
				if(vowCnt == 3) return false;
			}else {
				++conCnt;
				vowCnt = 0;
				if(conCnt == 3) return false;
			}
			
		}
		
		return true;
	}

	private static boolean check1(String str) {
		
		for(int i = 0, len = str.length(); i < len; ++i) {
			if(vowel[(int)(str.charAt(i) - 'a')]) return true;
		}
		return false;
	}

	private static String Password(String str, boolean isPassword) {
		String answer;
		if(isPassword) answer = "<" + str + ">" + " is acceptable.\n";
		else answer = "<" + str + ">" + " is not acceptable.\n";
		return answer;
	}

}
