import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		int[] count = new int['Z' - 'A' + 1];
		
		for(int i = 0; i < str.length(); i++) {
			count[str.charAt(i)-'A']++;
		}
		
		int max = 0;
		int idx = 0;
		for(int i = 0 ; i< count.length; i++) {
			if(count[i] > max) {
				max = count[i];
				idx = i;
			}
		}
		
		boolean isSame = false;
		for(int i = 0 ; i< count.length; i++) {
			if(i != idx && count[i] == max) {
				isSame = true;
				System.out.println("?");
				break;
			}
		}
		  
		if(!isSame) {
			System.out.println((char)('A'+idx));
		}
		
	}

}