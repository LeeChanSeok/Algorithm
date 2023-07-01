import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
	static int N;
	static String[] words;
	static int[] alphabet;
	static int max;
	static int alpha_cnt = (int)('Z' - 'A') + 1;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		alphabet = new int[(int)alpha_cnt];
		Arrays.fill(alphabet, -1);
		
		N = Integer.parseInt(br.readLine());
		words = new String[N];
		
		for(int i = 0; i < N; ++i) {
			String word = br.readLine();
			words[i] = word;
			for(int j = 0, len = word.length(); j < len; ++j) {
				alphabet[(int)(word.charAt(j) - 'A')] = 0;
			}
		}
		
		max = 0;
		recursive(0, 0);
		System.out.println(max);

	}

	private static void recursive(int idx, int flag) {
		
		if(idx == alpha_cnt) {
			max = Math.max(max, calc());
			return ;
		}
		
		if(alphabet[idx] == -1) recursive(idx+1, flag);
		else {
			for(int i = 0; i < 10; ++i) {
				if((flag & (1 << i)) != 0) continue;
				alphabet[idx] = i;
				recursive(idx + 1, flag | (1 << i));
			}
		}
	}

	private static int calc() {
		
		int total = 0;
		
		for(int i = 0; i < N; ++i) {
			int sum = 0;
			String word = words[i];
			for(int j = 0, len = word.length(); j < len; ++j) {
				sum = sum * 10 + alphabet[(int)(word.charAt(j) - 'A')];
			}
			
			total += sum;
		}
		
		return total;
	}

}