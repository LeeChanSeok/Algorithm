import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";
		
		if(str.equals(ascending)) System.out.println("ascending");
		else if(str.equals(descending)) System.out.println("descending");
		else System.out.println("mixed");

	}

}
