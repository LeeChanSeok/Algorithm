import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer> p = new ArrayList<>();
	
	
	public static boolean isPrime(int num) {
		if (num == 1)
			return false;
		else if (num == 2)
			return true;
		for (int i = 2; i < Math.sqrt(num) + 1; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Start = 1;
		int End = 10;
		for (int i = 0; i < N - 1; i++) {
			Start *= 10;
			End *= 10;
		}
		p.add(2); p.add(3); p.add(5); p.add(7);
		
		int digit, temp;
		boolean isPrime;
		for (int i = Start; i < End; i++) {
			
			digit = End/10;			
			isPrime = true;
			
			if(!p.contains(i/digit)) {
				i = i + digit - 1;
				continue;
			}
			
			while(digit != 0) {
				temp = i / digit;
				digit /= 10;
				if(!isPrime(temp)) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) System.out.println(i);			

		}

	}

}
