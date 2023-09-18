import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int s;
	static String n;
	static int digit, mid, bottom;
	
	static char[][] lcd;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		s = Integer.parseInt(st.nextToken());
		n = st.nextToken();
		digit = n.length();
		
		lcd = new char[2*s + 3][(s + 3) * digit];
		
		mid = s + 1;
		bottom = 2 * s + 2;
		
		for(int i = 0; i <= bottom; ++i) {
			Arrays.fill(lcd[i], ' ');
		}
		
		for(int i = 0; i < digit; ++i) {
			solution((s + 3) * i, n.charAt(i));
		}
		
		for(int i = 0; i <= bottom; ++i) {
			for(int j = 0, end = (s + 3) * digit; j < end; ++j) {
				sb.append(lcd[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}


	private static void solution(int idx, char num) {

		if(num == '0') {
			for(int i = 1; i <= s; ++i) {
				lcd[0][idx + i] = lcd[bottom][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx] = lcd[j][idx + s + 1] = '|' ;
				lcd[j+s+1][idx] = lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
		else if(num == '1') {
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx + s + 1] = lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
		else if(num == '2') {
			for(int i = 1; i <= s; ++i) {
				lcd[0][idx + i] = lcd[mid][idx + i] = lcd[bottom][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx + s + 1] = lcd[j+s+1][idx] = '|' ;
			}
		}
		else if(num == '3') {
			for(int i = 1; i <= s; ++i) {
				lcd[0][idx + i] = lcd[mid][idx + i] = lcd[bottom][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx + s + 1] = lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
		else if(num == '4') {
			for(int i = 1; i <= s; ++i) {
				lcd[mid][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx] = lcd[j][idx + s + 1] = '|' ;
				lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
		else if(num == '5') {
			for(int i = 1; i <= s; ++i) {
				lcd[0][idx + i] = lcd[mid][idx + i] = lcd[bottom][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx] = lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
		else if(num == '6') {
			for(int i = 1; i <= s; ++i) {
				lcd[0][idx + i] = lcd[mid][idx + i] = lcd[bottom][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx] = '|' ;
				lcd[j+s+1][idx] = lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
		else if(num == '7') {
			for(int i = 1; i <= s; ++i) {
				lcd[0][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx + s + 1] = lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
		else if(num == '8') {
			for(int i = 1; i <= s; ++i) {
				lcd[0][idx + i] = lcd[mid][idx + i] = lcd[bottom][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx] = lcd[j][idx + s + 1] = '|' ;
				lcd[j+s+1][idx] = lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
		else if(num == '9') {
			for(int i = 1; i <= s; ++i) {
				lcd[0][idx + i] = lcd[mid][idx + i] = lcd[bottom][idx + i] = '-';
			}
			
			for(int j = 1; j <= s; ++j) {
				lcd[j][idx] = lcd[j][idx + s + 1] = '|' ;
				lcd[j+s+1][idx + s + 1] = '|' ;
			}
		}
	}

}