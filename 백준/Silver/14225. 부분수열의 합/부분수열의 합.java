import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int MAX = 2000000;
	static int N;
	static int[] numArr;
	static boolean[] sumArr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) numArr[i] = Integer.parseInt(st.nextToken());
		
		sumArr = new boolean[MAX+1];
		recursive(0, 0);

		for(int i = 1; i <= MAX; ++i) {
			if(!sumArr[i]) {
				System.out.println(i);
				break;
			}
		}

	}

	private static void recursive(int idx, int sum) {
		
		if(idx == N) {
			sumArr[sum] = true;
			return;
		}
		
		recursive(idx+1, sum + numArr[idx]);
		recursive(idx+1, sum);
		
	}

}