import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static char[][] S;
	static int[] num, temp;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}


	private static void pro() {

		recursive(1);
		
	}


	private static boolean recursive(int idx) {

		if(idx == n + 1) {
			printAns();
			return true;
		}
		
		int s = -10;
		int e = 10;
		
		if(S[idx][idx] == '+') s = 1;
		else if(S[idx][idx] == '-') e = -1;
		else s = e = 0;
		
		for(int i = s; i <= e; ++i) {
			num[idx] = i;
			if(isRight(idx)) {
				if(recursive(idx + 1)) return true;
			}
		}
		
		return false;
	}


	private static void printAns() {

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; ++i) sb.append(num[i]).append(' ');
		System.out.println(sb);
	}


	private static boolean isRight(int idx) {

		for(int i = 1; i <= idx; ++i) {
			temp[i] = num[i] + temp[i-1];
		}
		
		for(int i = 1; i <= idx; ++i) {
			for(int j = i; j <= idx; ++j) {
				int subSum = temp[j] - temp[i - 1];
				if(subSum > 0 && S[i][j] != '+') return false;
				if(subSum < 0 && S[i][j] != '-') return false;
				if(subSum == 0 && S[i][j] != '0') return false;
			}
		}
		
		return true;
	}


	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		S = new char[n + 1][n + 1];
		int idx = 0;
		
		String str = br.readLine();
		for(int i = 1; i <= n; ++i) {
			for(int j = i; j <= n; ++j) {
				S[i][j] = str.charAt(idx++); 
			}
		}
		
		num = new int[n + 1];
		temp = new int[n + 1];
	}

}