import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {

	static int N;
	static String[] star;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		star = new String[N];
		star[0] = "  *   ";
		star[1] = " * *  ";
		star[2] = "***** ";
		
		
		recursive(3);
		
		for(int i = 0; i < N; ++i) {
			sb.append(star[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
	private static void recursive(int n) {
		
		if(n == N) return;
		
		int idx;
		String blank = "";
		for(int i = 0; i < n; ++i) blank += " ";
		for(int i = 0; i < n; ++i) {
			star[i+n] = star[i] + star[i];
			star[i] = blank + star[i] + blank;
		}
		recursive(n*2);
		
	}

}
