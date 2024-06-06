import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int range = (int) ('z' - 'a' + 1);
		int[] arr1 = new int[range];
		int[] arr2 = new int[range];

		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();

		for(char c : str1) {
			++arr1[(int) ('z' - c)];
		}
		for(char c : str2) {
			++arr2[(int) ('z' - c)];
		}

		int cnt = 0;
		for (int i = 0; i < range; ++i) {
			cnt += Math.abs(arr1[i] - arr2[i]);
		}

		System.out.println(cnt);
		
	}
	
}