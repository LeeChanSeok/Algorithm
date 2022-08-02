import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("src/hw/d0802/N1208/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int[] height = new int[100];
			for (int i = 0; i < height.length; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(height);
			int i = 0; 
			int j = height.length-1;
			int cnt = 0;
			while(cnt < dump) {
				i = 0; j = height.length-1;
				for(; i < height.length-1; ++i) {
					if(height[i] < height[i+1]) break;
				}
				
				for(; j >= 0 && j >= i; --j) {
					if(height[j] > height[j-1]) break;
				}
				
				if(height[j] - height[i] <= 1) break;
				
				
				height[i]++;
				height[j]--;
				cnt++;
					
			}

			System.out.printf("#%d %d\n", test_case, height[height.length-1] - height[0]);

		}
	}
}