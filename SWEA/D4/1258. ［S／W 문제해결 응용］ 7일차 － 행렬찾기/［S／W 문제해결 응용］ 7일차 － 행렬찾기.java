import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static class Chemical implements Comparable<Chemical>{
		int x, y, multi;

		public Chemical(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.multi = x * y;
		}

		@Override
		public int compareTo(Chemical o) {
			if(this.multi == o.multi) return this.x - o.x;
			else return this.multi - o.multi;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++)
					arr[i][j] = st.nextToken().charAt(0);
			}
		
			List<Chemical> chemicals = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <N;j++) {
					if(arr[i][j] == '0') continue;
					
					int r = 0, c = 0;
					for(int i2 = i; i < N; ++i2, r++) {
						if(arr[i2][j] == '0') break;
					}

					for(int j2 = j; j < N; ++j2, c++) {
						if(arr[i][j2] == '0') break;
					}
					
					chemicals.add(new Chemical(r, c));
					
					for(int i2 = 0; i2 < r; i2++)
						for(int j2 = 0; j2 < c; j2++)
							arr[i+i2][j+j2] = '0';
					
				}
			}
			sb = new StringBuilder("#" + tc + " " + chemicals.size() + " ");
			Collections.sort(chemicals);
			for(Chemical chemi : chemicals)
				sb.append(chemi.x + " " + chemi.y + " ");
			
			System.out.println(sb.toString());
		}
	}
}