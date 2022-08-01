import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int[42];
		
		for(int i = 0 ; i < 10; i++) {
			count[sc.nextInt()%42]++;
		}
		
		int ans = 0;
		for(int i : count)
			if(i!=0) ans++;
		
		System.out.println(ans);
	}

}
