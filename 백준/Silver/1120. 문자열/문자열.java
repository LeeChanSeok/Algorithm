import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] a = st.nextToken().toCharArray(); 
		char[] b = st.nextToken().toCharArray(); 
		
		int alen = a.length;
		int blen = b.length;
		int diff = blen - alen;
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= diff; ++i) {
			int cnt = 0;

			for(int j = 0; j < alen; ++j) {
				if(a[j] != b[i + j]) ++cnt;
				if(cnt >= min) break;
			}
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
				
	}

}