import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static boolean[][] A, B;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		A = new boolean[n][m];
		B = new boolean[n][m];
		
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < m; ++j) {
				A[i][j] = (str.charAt(j) == '0')?false:true;
				
			}
		}
		
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < m; ++j) {
				B[i][j] = (str.charAt(j) == '0')?false:true;
				
			}
		}
		
		int cnt = 0;
		if(n >= 3 && m >= 3) {
			
			for(int i = 0; i <= n-3; ++i) {
				for(int j = 0; j <= m-3; ++j) {
					if(A[i][j] != B[i][j]) {
						++cnt;
						toggle(i, j);
					}
				}
			}
			
		}
		
		int res = (isSame())?cnt : -1;
		System.out.println(res);
		
	}

	private static void toggle(int x, int y) {
		for(int i = x; i < x + 3; ++i) {
			for(int j = y; j < y + 3; ++j) {
				A[i][j] = !A[i][j];
			}
		}
		
	}

	private static boolean isSame() {

		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(A[i][j] != B[i][j]) return false;
			}
		}
		
		return true;
	}

}