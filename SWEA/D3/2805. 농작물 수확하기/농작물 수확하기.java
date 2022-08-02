import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/hw/d0802/N2805/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				String temp = br.readLine();
				for(int j = 0; j < N; j++)
					arr[i][j] = temp.charAt(j)-'0';				
			}
			
			int mid = N/2;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(i <= mid) {
					for(int j = mid - i; j <= mid + i; j++)
						sum += arr[i][j];
				}else {
					for(int j = i - mid; j < N - (i - mid) ; j++)
						sum += arr[i][j];
				}
			}
			System.out.printf("#%d %d\n",tc, sum);
		}
	}

}