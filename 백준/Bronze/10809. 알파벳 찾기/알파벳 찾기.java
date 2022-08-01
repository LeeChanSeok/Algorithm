import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int['z'-'a'+1];
		String str = sc.nextLine();
		for(int i = 0 ; i < str.length(); i++) {
			if (count[str.charAt(i)-'a'] == 0) count[str.charAt(i)-'a'] = i+1; 
		}
		for(int i : count)
			if(i == 0) {
				System.out.print(-1 + " ");
			}else{
				System.out.print((i-1) + " ");	
			}
			
		System.out.println();

	}

}
