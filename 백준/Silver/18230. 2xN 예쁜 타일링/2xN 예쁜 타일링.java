import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Integer[] A_arr = new Integer[A];
		Integer[] B_arr = new Integer[B];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < A; ++i) {
			A_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A_arr, Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < B; ++i) {
			B_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(B_arr, Collections.reverseOrder());
		
		int total = 0;
		int aPos = 0, bPos = 0;
		if(N % 2 == 1) total += A_arr[aPos++];
		
		while(bPos * 2 + aPos < N) {
			
			int aSum = 0, bSum = 0;
			
			if(aPos < A - 1) aSum = A_arr[aPos] + A_arr[aPos + 1];
			if(bPos < B) bSum = B_arr[bPos];
			
			if(aSum >= bSum) {
				total += aSum;
				aPos += 2;
			} else {
				total += bSum;
				++bPos;
			}
			
		}
		
		System.out.println(total);
		
	}

}