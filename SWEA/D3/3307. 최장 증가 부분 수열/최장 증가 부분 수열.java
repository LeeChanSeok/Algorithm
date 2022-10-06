import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N, size, pos, insertPos;
		int[] arr, C;
		
		for(int tc = 1; tc <= T; ++tc) {
			
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			C = new int [N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			size = 0;
			for(int i = 0; i < N; ++i) {
				pos = Arrays.binarySearch(C, 0, size, arr[i]);
				if(pos >= 0) continue;
				
				insertPos = -pos - 1;
				if(insertPos == size) ++size;
				C[insertPos] = arr[i];
			}
			
			System.out.printf("#%d %d\n", tc, size);
		}// tc 종료

	}

}