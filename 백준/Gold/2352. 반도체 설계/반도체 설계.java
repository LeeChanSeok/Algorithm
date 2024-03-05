import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] LIS;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		LIS = new int[n];
		LIS[0] = arr[0];
		int i = 1;
		int j = 0;
		
		while(i < n) {
			
			if(arr[i] > LIS[j]) {
				LIS[++j] = arr[i];
			}else {
				int idx = binarySearch(0, j, arr[i]);
				LIS[idx] = arr[i];
			}
			
			++i;
		}
		
		System.out.println(j+1);
		
	}

	private static int binarySearch(int left, int right, int target) {
		int mid = 0;
		while(left < right) {
			mid = (left + right) /  2;
			
			if(LIS[mid] < target) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		return right;
	}

}