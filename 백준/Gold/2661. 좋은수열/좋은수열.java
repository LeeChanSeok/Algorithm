import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String ans;
	static int n;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();

	}

	private static void pro() {
		ans = "";
		dfs("");
		System.out.println(ans);
	}

	private static boolean dfs(String str) {
		
		if(!isGood(str)) return false;
		
		if(str.length() == n) {
			ans = str;
			return true;
		}
		
		if(dfs(str + "1")) return true;;
		if(dfs(str + "2")) return true;;
		if(dfs(str + "3")) return true;;
		
		return false;
	}

	private static boolean isGood(String str) {
		
		int len = str.length();

		for(int i = 1; i <= len / 2; ++i)
		{
			if(str.substring(len - i).equals(str.subSequence(len - i * 2, len - i))) return false;
		}
		
		return true;
		
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	}

}