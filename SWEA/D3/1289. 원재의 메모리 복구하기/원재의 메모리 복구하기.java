import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			char[] target = sc.nextLine().toCharArray();
			char[] my = new char[target.length];
			
			int len = target.length;
			for(int i = 0; i < len; i++)
				my[i] = '0';

			int cnt = 0;
			for(int i = 0; i < len; i++) {
				char temp = my[i];
				if (cnt % 2 == 1) {
					if(temp == '0') temp = '1';
					else temp = '0';
				}				
				
				if(temp != target[i]) {
					cnt++;					
				}
			}
				
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
}