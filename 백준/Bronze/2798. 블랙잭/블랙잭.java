import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int max;
	public static void combination(Integer[] arr, int cnt, int idx, int sum, int N, int M) {
		if(sum > M) return;
		if(cnt == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = idx; i < N; i++) {
			combination(arr, cnt+1, i+1, sum + arr[i], N, M);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		//Arrays.sort(arr);
		Arrays.sort(arr, Collections.reverseOrder());
		
		max = Integer.MIN_VALUE;
		combination(arr, 0, 0, 0, N, M);
		System.out.println(max);
	}
}
