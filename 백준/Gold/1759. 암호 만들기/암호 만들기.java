import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static int L, C;
	public static int cnt, idx, vCnt, cCnt;
	public static char[] input, pick;
	public static StringBuilder sb;
	public static List<Character> vowels = new ArrayList<>(5);
	
	public static void combination(int cnt, int idx, int vCnt, int cCnt) {
		if(cnt == L) {
			if(vCnt >= 1 && cCnt >= 2)	sb.append(pick).append("\n");
			return;
		}
		
		for(int i = idx; i < C; i++) {
			pick[cnt] = input[i];			
			if(vowels.contains(input[i])) combination(cnt+1, i+1, vCnt+1, cCnt);
			else combination(cnt+1, i+1, vCnt, cCnt+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
		
		String[] str = br.readLine().toString().split(" ");
		L = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		input = br.readLine().replace(" ", "").toCharArray();
		pick = new char[L];
		
		Arrays.sort(input);
		
		combination(0, 0, 0, 0);
		bw.write(sb.toString());
		bw.close();
	}

}