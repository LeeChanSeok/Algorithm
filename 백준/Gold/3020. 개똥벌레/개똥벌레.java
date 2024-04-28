import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] down = new int[n/2];
		int[] up = new int[n/2];
		
		for(int i = 0; i < n/2; ++i) {
			down[i] = Integer.parseInt(br.readLine());
			up[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(down);
		Arrays.sort(up);
		
		int cnt = 0;
		int min = n;
		for(int i = 1; i < h + 1; ++i) {
			int conflict = low_bound(0, n/2, i, up) + low_bound(0, n/2, h - i + 1, down);
			
			if(min == conflict) ++cnt;
			else if (min > conflict){
				min = conflict;
				cnt = 1;
			}
		}
		
		System.out.println(min + " " + cnt);
		
	}

	private static int low_bound(int left, int right, int h, int[] arr) {

		int res = h;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] < h ) {
				 left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return arr.length - right;
	}

}