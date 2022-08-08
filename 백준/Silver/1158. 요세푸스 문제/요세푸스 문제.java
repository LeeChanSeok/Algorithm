import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int remove = 0;
		int idx = 1;
		int cnt = 0;
		boolean[] isRemove = new boolean[N+1];
		
		System.out.print("<");
		while(remove != N) {
			if(!isRemove[idx]) cnt++;
			
			if(cnt == K) {
				isRemove[idx] = true;
				remove++;
				if(remove == N)
					System.out.print(idx);
				else
					System.out.print(idx + ", ");
				cnt = 0;
			}
			
			idx++;
			if(idx == N+1) idx = 1;
		}
		System.out.println(">");
		
	}
	
}