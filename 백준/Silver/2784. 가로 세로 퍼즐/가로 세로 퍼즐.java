import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n = 6;
	static String[] words = new String[n];
	static String[] select = new String[n/2];
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		if(!dfs(0, 0)) {
			System.out.println(0);	
		}	
	}

	private static boolean dfs(int idx, int flag) {

		if(idx == 3) {
			if(isFind(flag)) {
				print();
				return true;
			}
			return false;
		}
		
		
		for(int i = 0; i < n; ++i) {
			if(((1 << i) & flag) == 0) {
				select[idx] = words[i];
				if(dfs(idx + 1, flag | (1 << i))) return true;
			}
		}
		return false;
		
	}

	private static void print() {

		for(int i = 0; i < 3; ++i) {
			System.out.println(select[i]);
		}
		
	}

	private static boolean isFind(int flag) {

		String[] ver_word = new String[3];
		Arrays.fill(ver_word, "");
		
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				ver_word[j] += select[i].charAt(j);
			}
		}
				
		for(int i = 0; i < 3; ++i) {
			
			for(int j = 0; j < n; ++j) {
				if(((1 << j) & flag) != 0) continue;
				
				if(ver_word[i].equals(words[j])) {
					flag |= (1 << j);
					break;
				}
				
			}
		}
		
		
		return flag == (1 << n) - 1;
	}

	private static void input() throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < n; ++i) {
			words[i] = br.readLine();
		}
	}

}