import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		arr = new char[n][n];
		for(int i = 0; i < n; ++i) {
			Arrays.fill(arr[i], '*');
		}
		int k = n / 3;
		recursive(0, 0, n);
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
	}

	private static void recursive(int x, int y, int n) {

		if(n == 0) return;
		
		int k = n / 3;
		
		recursive(x, y, k);
		recursive(x, y + k , k);
		recursive(x, y + (k * 2), k);
		
		recursive(x + k, y, k);
		for(int i = 0; i < k ; ++i) {
			Arrays.fill(arr[x + k + i], y + k, y + (k * 2) , ' ');
		}
		recursive(x + k, y + (k * 2), k);
		
		recursive(x + (k * 2), y, k);
		recursive(x + (k * 2), y + k , k);
		recursive(x + (k * 2), y + (k * 2), k);
	}

}