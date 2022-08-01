import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 1;
		for(int i = 0 ; i < 3; i++) {
			sum *= sc.nextInt();
		}
		
		String str = String.valueOf(sum);
		int[] count = new int[10];
		for(int i = 0; i < str.length(); i++)
			count[str.charAt(i)-'0']++;
	
		for(int i : count)
			System.out.println(i);
		
	}

}