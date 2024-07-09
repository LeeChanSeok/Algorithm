import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = 26;
		char[] arr = new char[N];
		
		String code = br.readLine();
		int len = code.length();
		
		int K = Integer.parseInt(br.readLine());
		Set<Character> alphabet = new HashSet<>();
		
		int idx = K - 1;
		for(int i = 0; i < len; ++i) {
			char c = code.charAt(i);
			alphabet.add(c);
			arr[c - 'A'] = (char)(idx + 'A');
			idx = (idx + 1) % N;
		}
		
		for(char c = 'A'; c <= 'Z'; ++c) {
			if(alphabet.contains(c)) continue;
			arr[c - 'A'] = (char)(idx + 'A');
			idx = (idx + 1) % N;
		}
		
		String input = br.readLine();
		for(int i = 0; i < input.length(); ++i) {
			char c = input.charAt(i);
			sb.append(arr[c - 'A']);
		}
		
		System.out.println(sb);

	}

}