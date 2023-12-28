import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		if(isPalindrome(str)) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}

	}

	private static boolean isPalindrome(String str) {

		int len = str.length();
		for(int i = 0; i <= len/2; ++i) {
			if(str.charAt(i) != str.charAt(len - i - 1)) return false;
		}
		return true;
	}

}