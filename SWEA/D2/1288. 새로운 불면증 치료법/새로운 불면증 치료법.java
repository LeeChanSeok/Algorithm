import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int mask = (1 << 10) - 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			int visit = 0;
			int count = 0;
			
			while(visit != mask) {
				char[] digits = String.valueOf(N * ++count).toCharArray();
				for(char c : digits) {
					int number = c - '0';
					visit |= (1 << number);
				}
			}
			
			System.out.printf("#%d %d\n", test_case, N*count);
		}
	}
}