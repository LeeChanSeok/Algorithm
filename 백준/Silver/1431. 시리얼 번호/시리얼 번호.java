import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class Guitar{
		String serial;
		int len;
		int sum;
		public Guitar(String serial) {
			super();
			this.serial = serial;
			
			this.len = serial.length();
			this.sum = calc_Sum(serial, this.len);
		}
		private int calc_Sum(String serial, int len) {

			int sum = 0;
			for(int i = 0; i < len; ++i) {
				char c = serial.charAt(i);
				if(c >= '0' && c <= '9') sum += (int)(c - '0');
				
			}
			
			return sum;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Guitar[] guitars = new Guitar[n];
		
		for(int i = 0; i < n; ++i) {
			guitars[i] = new Guitar(br.readLine());
		}
		
		Arrays.sort(guitars, (g1, g2) -> {
			if(g1.len == g2.len) {
				if(g1.sum == g2.sum) {
					return g1.serial.compareTo(g2.serial);
				}
				return g1.sum - g2.sum;
			}
			return g1.len - g2.len;
		});
		
		for(Guitar guitar : guitars) {
			System.out.println(guitar.serial);
		}
	}

}