import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static char[] words;
	static String prev;
	static int len;
	static StringBuilder sb, sent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			words = br.readLine().toCharArray();
			Arrays.sort(words);
			sent = new StringBuilder();
			prev = "";
			len = words.length;
			recursive(0, 0);
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}
	private static void recursive(int idx, int flag) {
		
		if(idx == len) {
			sb.append(sent.toString()).append("\n");
			return;
		}
		
		char p = '\0';
		for(int i = 0; i < len; ++i) {
			if(words[i] == p || (flag & (1 << i)) != 0) continue;
			p = words[i];
			sent.append(words[i]);
			recursive(idx + 1, flag | (1 <<i));
			sent.deleteCharAt(sent.length()-1);
		}
		
		
	}

}
