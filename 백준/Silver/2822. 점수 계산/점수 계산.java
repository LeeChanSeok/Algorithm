import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static class Problem{
		int id;
		int score;
		public Problem(int id, int score) {
			super();
			this.id = id;
			this.score = score;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Problem[] problems = new Problem[8];
		for(int i = 0; i < 8; ++i) {
			problems[i] = new Problem(i+1, sc.nextInt());
		}
		
		Arrays.sort(problems, (p1, p2) -> p2.score - p1.score);
		
		int[] order = new int[5];
		int sum = 0;
		for(int i = 0; i < 5; ++i) {
			sum += problems[i].score;
			order[i] = problems[i].id;
		}
		System.out.println(sum);
		
		Arrays.sort(order);
		for(int i = 0; i < 5; ++i) {
			System.out.print(order[i] + " ");
		}

	}

}