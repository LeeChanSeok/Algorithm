import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, A, B;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		Arrays.fill(arr, K);
		
		int ans = 0;
		int idx = 0;
		while(true) {
			if(isDie()) break;
			for(int i = 0; i < A; ++i) {
				arr[idx] += B;
				idx = (idx + 1) % N;
			}
			for(int i = 0; i < N; ++i) --arr[i];
			++ans;
		}

		System.out.println(ans);
	}

	private static boolean isDie() {
		for(int num : arr) {
			if(num == 0) return true;
		}
		return false;
	}

}