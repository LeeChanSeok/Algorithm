import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int A, B;
	static int ans;
	static int len;
	static int[] num = new int[10];
	static int[] digit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		len = 0;
		int tempA = A;
		while(tempA != 0) {
			++num[tempA % 10];
			tempA /= 10;
			++len;
		}
	
		ans = -1;
		recursive(0, 0);
		System.out.println(ans);

	}

	private static boolean recursive(int idx, int C) {
		
		if(C >= B) return false; 
		if(idx == len) {
			ans = C;
			return true;
		}
		
		for(int i = 9; i >= 0; --i) {
			if(num[i] == 0) continue;
			if(i == 0 && idx == 0) continue;
			
			--num[i];
			if(recursive(idx + 1, C + i * (int)Math.pow(10, len - idx - 1))) return true;
			++num[i];

		}
		
		return false;
	}

}