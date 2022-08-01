import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().trim().split(" ");
		int len = str.length;
		if(len == 1 && str[0].equals("")) len--;
		System.out.println(len);

	}

}
