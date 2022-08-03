import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int max;
	public static int min;
	public static char[] operator = {'+', '-', '*', '/'};

	
	public static int calc(int[] numArr, char[] op) {
		int res = numArr[0];
		for(int i = 0; i < op.length; i++) {
			switch(op[i]) {
				case '+' : {
					res += numArr[i+1];
					break;
				}
				case '-' : {
					res -= numArr[i+1];
					break;
				}
				case '*' : {
					res *= numArr[i+1];
					break;
				}
				case '/' : {
					if (res < 0) { 
						res = res * -1;
						res /= numArr[i+1];
						res = res * -1;
					}
					else
						res /= numArr[i+1];
					break;
				}
			}
		}
		
		return res;
	}
	
	public static void dfs(int[] numArr, int[] ops, char[] op, int cnt) {
		if(cnt == N-1) {
			int res = calc(numArr, op);
			min = Math.min(min, res);
			max = Math.max(max, res);
			return;
		}
		
		for(int i = 0; i < ops.length; i++) {
			if(ops[i] != 0) {
				op[cnt] = operator[i];
				ops[i]--;
				dfs(numArr, ops, op, cnt+1);
				op[cnt] = ' ';
				ops[i]++;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			numArr[i] = Integer.parseInt(st.nextToken());
		
		int[] ops = new int[4];
		char[] op = new char[N-1];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++)
			ops[i] = Integer.parseInt(st.nextToken());
		
		
		dfs(numArr, ops, op, 0);
			
		System.out.println(max);
		System.out.println(min);
		
	}

}