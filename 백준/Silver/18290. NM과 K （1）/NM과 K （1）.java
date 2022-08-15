import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M, K;
	public static int idx, cnt, sum;
	public static int max;
	public static int[] arr;
	public static boolean[][] isSelected;
	
	public static void combination(int idx, int cnt, int sum) {
		if(cnt == K) {
			max = Math.max(max, sum);
			return ;
		}
		
		for(int i = idx; i < N*M; i++) {
			if(i/M != 0 && isSelected[(i-M)/M][(i-M)%M]) continue;
			if(i%M != 0 && isSelected[(i-1)/M][(i-1)%M]) continue;
			isSelected[i/M][i%M] = true;
			combination(i+1, cnt + 1, sum + arr[i]);
			isSelected[i/M][i%M] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N*M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< M; j++)
				arr[i*M + j] = Integer.parseInt(st.nextToken());
		}
		isSelected = new boolean[N][M];
		
		max = Integer.MIN_VALUE;
		combination(0, 0, 0);
		System.out.println(max);
	}

}