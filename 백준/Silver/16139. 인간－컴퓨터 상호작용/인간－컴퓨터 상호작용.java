import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str = br.readLine();
		int len = str.length();
		
		int[][] arr = new int[26][len+1];
		for(int i = 1; i <= len; ++i) {
			for(int j = 0; j < 26; ++j) {
				arr[j][i] = arr[j][i-1];
			}
			char c = str.charAt(i-1);
			++arr[(int)(c-'a')][i]; 
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken())+1;
			int r = Integer.parseInt(st.nextToken())+1;
			
			int cnt = arr[(int)(c - 'a')][r] - arr[(int)(c - 'a')][l-1];
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}

}