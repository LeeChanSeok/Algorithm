import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int AC, AP;
		st = new StringTokenizer(br.readLine());
		AC = Integer.parseInt(st.nextToken());
		AP = Integer.parseInt(st.nextToken());
		
		int BC, BP;
		st = new StringTokenizer(br.readLine());
		BC = Integer.parseInt(st.nextToken());
		BP = Integer.parseInt(st.nextToken());

		long P = AP * BP;
		long C = AC * BP + BC * AP;
		
		long gcd = gcd(C, P);
		
		System.out.println(C/gcd + " " + P/gcd);
	}
	
	public static long gcd(long a, long b) {
		if(a % b == 0) return b;
		return gcd(b, a%b);
	}

}
