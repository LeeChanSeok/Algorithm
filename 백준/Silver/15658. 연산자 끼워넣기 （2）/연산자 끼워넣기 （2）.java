import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final char[] op = {'+', '-', '*', '/'};
	
	static int[] numbers;
	static int[] operCnt;
	static char[] opers;
	static int N;
	static int min, max;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) numbers[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		operCnt = new int[4];
		for(int i = 0; i < 4; ++i) operCnt[i] = Integer.parseInt(st.nextToken());
		
		opers = new char[N-1];
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		recursive(0);
		
		System.out.println(max);
		System.out.println(min);
		
		
	}
	private static void recursive(int idx) {
		if(idx == N-1) {
			calc();
			return;
		}
		
		for(int i = 0; i < 4; ++i) {
			if(operCnt[i] == 0) continue;
			
			--operCnt[i];
			opers[idx] = op[i];
			recursive(idx + 1);
			++operCnt[i];
		}
		
		
	}
	private static void calc() {
		
		int num = numbers[0];
		
		for(int i = 1; i < N; ++i) {
			
			if(opers[i-1] == '+') {
				num += numbers[i];
			}
			else if(opers[i-1] == '-') {
				num -= numbers[i];
			}
			else if(opers[i-1] == '*') {
				num *= numbers[i];
			}
			else if(opers[i-1] == '/') {
				if(num < 0) {
					num = -((-num)/numbers[i]);
				}else
					num /= numbers[i];
			}

		}
		
		min = Math.min(min, num);
		max = Math.max(max, num);
		
	}

}
