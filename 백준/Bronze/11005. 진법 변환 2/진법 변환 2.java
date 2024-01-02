import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		String ans = "";
		
		while(n != 0) {
			int num = n % b; 
			char digit = num2char(num);
			
			ans = digit + ans;
			n/=b;
		}
		
		System.out.println(ans);

	}

	private static char num2char(int num) {
		if(num >= 10) return (char)(num - 10 + 'A');
		else return (char)(num + '0');
	}

}