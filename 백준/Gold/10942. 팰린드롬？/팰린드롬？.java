import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] number;
	static boolean[][] palindrome;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		number = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) number[i] = Integer.parseInt(st.nextToken());
		
		palindrome = new boolean[N][N];
		
		init_palindrome();
		
		int s, e;
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			s = Integer.parseInt(st.nextToken())-1;
			e = Integer.parseInt(st.nextToken())-1;
			
			sb.append(((palindrome[s][e])?1:0) + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

	private static void init_palindrome() {

		for(int s = 0; s < N; ++s) {
			for(int e = s; e < N; ++e) {
				palindrome[s][e] = is_Palindrome(s,e);
			}
		}
		
	}

	private static boolean is_Palindrome(int s, int e) {

		while(s <= e) {
			if(number[s] != number[e]) return false;
			++s; --e;
		}
		
		return true;
	}

}