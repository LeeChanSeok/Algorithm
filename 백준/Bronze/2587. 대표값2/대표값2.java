import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 5;
		int[] arr = new int[n];
		int sum = 0;
		for(int i = 0; i < n; ++i) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			arr[i] = num;
		}

		Arrays.sort(arr);
		System.out.println(sum / n);
		System.out.println(arr[2]);
	}

}