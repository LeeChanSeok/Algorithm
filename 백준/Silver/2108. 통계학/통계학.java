import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] cntArr = new int[8001];
		int sum = 0; int num;
		for(int i = 0; i < N; ++i) {
			num = Integer.parseInt(br.readLine());
			arr[i] = num;
			sum += num;
			++cntArr[num+4000];
		}
		
		Arrays.sort(arr);

		int max = 0;
		for(int i = 0; i < 8001; ++i) {
			max = Math.max(max, cntArr[i]);
		}
		
		boolean find = false;
		num = 0;
		for(int i = 0; i < 8001; ++i) {
			if(cntArr[i] == max) {
				if(!find) {
					num = i;
					find = true;
				}else {
					num = i;
					break;
				}
				
			}
			
		}
		
		System.out.println(Math.round((double)sum / N));
		System.out.println(arr[N/2]);
		System.out.println(num-4000);
		System.out.println(arr[N-1] - arr[0]);
		
	}

}