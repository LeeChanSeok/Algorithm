import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bubble_sort();
		
	}

	private static void bubble_sort() {
		StringBuilder sb = new StringBuilder();
		int change = 0;
		
		for(int last = n - 1; last >= 1; --last) {
			
			for(int i = 0; i < last; ++i) {
				if(arr[i] > arr[i+1]) {
					++change;
					
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					
					if(change == k) {
						for (int num : arr) {
							sb.append(num + " ");
						}
						System.out.println(sb);
						return;
					}
				}
			}
		}
		
		System.out.println("-1");
	}

}