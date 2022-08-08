import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int remove = 0;
		int cnt = 0;
		List<Integer> arr = new LinkedList<>();
		
		for(int i = 1; i <= N; i++)
			arr.add(i);
		
		System.out.print("<");
		int idx = 0;
		while(remove != N) {
			idx = (idx + K-1) % (N - remove);
			remove++;
			if(remove == N)
				System.out.print(arr.remove(idx));
			else
				System.out.print(arr.remove(idx) +", ");
		}
		System.out.println(">");
	}
}