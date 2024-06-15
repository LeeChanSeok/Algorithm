import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		arr = new int[n - 1];
		
		for(int i = 0; i < n - 1; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(solution(X)) System.out.println("Yes");
		else System.out.println("No");
	}

	private static boolean solution(int x) {
		
		long v = x;
		for(int i = 0; i < n - 1; ++i) {
			if(v <= arr[i]) return false;
			v += arr[i];
		}
		
		return true;
	}

}