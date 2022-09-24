import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[][] triangle;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		triangle = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		triangle[0][0] = Integer.parseInt(st.nextToken());
		int num;
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			triangle[i][0] = triangle[i-1][0] + num;
			
			for(int j = 1; j < i; j++) {
				num = Integer.parseInt(st.nextToken());
				triangle[i][j] = num + Math.max(triangle[i-1][j-1], triangle[i-1][j]); 
			}
			num = Integer.parseInt(st.nextToken());
			triangle[i][i] = triangle[i-1][i-1] + num;
		}
		
		max = 0;
		for(int j = 0; j < N; j++)
			max = Math.max(max, triangle[N-1][j]);
		System.out.println(max);

	}

}