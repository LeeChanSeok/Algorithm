import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		int N, M, x, y, k;
		int[] arr, temp, s;

		for (int tc = 1; tc <= T; tc++) {
			arr = new int[10];
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 10; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				st.nextToken(); // 'I' 제거
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				s = new int[y];
				for(int j = 0; j < y; j++)	
                    s[j] = Integer.parseInt(st.nextToken());
				
				temp = new int[10];	// 새로운 암호문을 저장할 배열
				for(k = 0; k < 10 && k < x; k++)  // 입력할 위치 앞부분의 배열값
                    temp[k] = arr[k]; 
                
				for(k = x; k < 10 && k-x < y; k++) // 추가할 배열값
                    temp[k] = s[k-x]; 
                
				while(k < 10) // 추가하고 남은 배열 값
                    temp[k++] = arr[x++]; 
				
				arr = temp.clone();
			} //명령어 종료
			
			System.out.print("#"+tc+" ");
			for(int i : arr) System.out.print(i + " ");
			System.out.println();
			
		} // test-case 종료

	}

}