import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dial = new int[26];
		dial[0] = dial[1] = dial[2] = 3;
		dial[3] = dial[4] = dial[5] = 4;
		dial[6] = dial[7] = dial[8] = 5;
		dial[9] = dial[10] = dial[11] = 6;
		dial[12] = dial[13] = dial[14] = 7;
		dial[15] = dial[16] = dial[17] = dial[18] = 8;
		dial[19] = dial[20] = dial[21] = 9;
		dial[22] = dial[23] = dial[24] = dial[25] = 10;
		
		int res = 0;
		String str = br.readLine();
		for(int i = 0, len = str.length(); i < len; ++i) {
			res += dial[(int)(str.charAt(i) - 'A')];
		}
		
		System.out.println(res);
	}

}