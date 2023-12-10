import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int remain = n % 3;
		if(remain == 1) remain = 2;
		else if(remain == 2) remain = 1;
		
		int x = n + remain;
		Integer[] arr = new Integer[x];
		
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		for(int i = n; i < x; ++i) {
			arr[i] = Integer.valueOf(0);
		}
		
		Arrays.sort(arr, Collections.reverseOrder());

		int cost = 0;
		for(int k = 0; k < x; k += 3) {
			cost += arr[k] + arr[k+1];
		}
		
		System.out.println(cost);
		
	}

}