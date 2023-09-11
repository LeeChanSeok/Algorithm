import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n1, n2;
	static String str1, str2;
	static int T; 
	static char[][] ant = new char[100][2];
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n2; ++i) {
			ant[i+n1][0] = str2.charAt(i);
		}
		
		for(int i = 0; i < n1; ++i) {
			ant[i+T][1] = str1.charAt(i);
		}
		
		for(int i = 0; i < 100; ++i) {
			if(ant[i][0] != '\0') sb.append(ant[i][0]);
			if(ant[i][1] != '\0') sb.append(ant[i][1]);
		}
			
		System.out.println(sb);
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		
		str1 = sb.append(br.readLine()).reverse().toString();
		str2 = br.readLine();
		
		T = Integer.parseInt(br.readLine());
	}

}