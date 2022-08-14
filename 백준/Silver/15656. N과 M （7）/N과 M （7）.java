import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[] input, numbers;
	public static boolean[] isSelected;
	public static StringBuffer sb;
	
	public static void permutation(int[] pick, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) sb.append(pick[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			pick[cnt] = input[i];
			permutation(pick, cnt+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuffer();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		input = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(input);
		
		permutation(numbers, 0);
		System.out.println(sb.toString());
	}
}