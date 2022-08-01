import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int new1 = 0;
		int new2 = 0;
		for(int i = 1; i <=3; i++) {
			new1 = new1*10 +  (num1%10);
			new2 = new2*10 +  (num2%10);
			num1/=10;
			num2/=10;
		}
		
		if(new1>new2) System.out.println(new1);
		else System.out.println(new2);
	}

}
