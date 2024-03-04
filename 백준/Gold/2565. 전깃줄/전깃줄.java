import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Line{
		int a, b;

		public Line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
		
	}
	
	static Line[] line;
	static int[] LIS;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		line = new Line[n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[i] = new Line(a, b); 
		}
		
		Arrays.sort(line, (l1, l2) -> l1.a - l2.a);
		
		LIS = new int[n];
		LIS[0] = line[0].b;
		int i = 1;
		int j = 0;
		
		while(i < n) {
			
			if(line[i].b > LIS[j]) {
				LIS[++j] = line[i].b;
			}else {
				int idx = binarySearch(0, j, line[i].b);
				LIS[idx] = line[i].b;
			}
			
			++i;
		}
		
		System.out.println(n - (j + 1));
		
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