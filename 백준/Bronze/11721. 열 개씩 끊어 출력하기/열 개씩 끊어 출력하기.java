import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.next();
		
		int len = str.length();
		int i = 0;
		while(true) {
			if((len - i) < 10) {
				sb.append(str.subSequence(i, len));
				break;
			}
			sb.append(str.subSequence(i, i + 10)).append('\n');
			i += 10;
		}
		
		System.out.println(sb);

	}

}