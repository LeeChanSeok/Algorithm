import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		System.out.println(solution());
	}

	private static int solution() {

		int l = 0;
		int r = 0;
		int max = 0;

		int type = 0;
		int[] cntArr = new int[10];
		while(r < N) {
			
			++cntArr[arr[r]];
			if(cntArr[arr[r]] == 1) {
				++type;
			}
			
			if(type > 2) {
				while(type != 2) {
					--cntArr[arr[l]];
					if(cntArr[arr[l]] == 0) --type;
					++l;
				}
			} else {
				max = Math.max(r - l + 1, max);
			}
			
			++r;
		}

		return max;
		
	}

}