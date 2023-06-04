import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] marble;
	static int[][] link;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		marble = new int[N]; 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) marble[i] = Integer.parseInt(st.nextToken());
		
		link = new int[2][N];
		for(int i = 1; i < N; ++i) link[0][i] = i - 1;
		for(int i = 0; i < N-1; ++i) link[1][i] = i + 1;
		
		max = 0;
		solution(N, 0);
		System.out.println(max);
	}
	
	private static void solution(int remain, int total) {

		if(remain == 2) {
			max = Math.max(max, total);
			return;
		}
		
		int num;
		int left, right;
		for(int i = 1; i < N-1; ++i) {
			num = marble[i];
			if(num == -1) continue;
			
			left = link[0][i];
			right = link[1][i];
			
			link[1][left] = link[1][i];
			link[0][right] = link[0][i];
			
			marble[i] = -1;
			solution(remain-1, total + (marble[left])*(marble[right]));
			
			marble[i] = num;			
			link[1][left] = link[0][right] = i;		
			
		}
		
	}

}
