import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	static int N, K, len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String numbers, password;
		Iterator<String> iter;
		
		TreeSet<String> passSet = new TreeSet<>(new Comparator<String>() {
			char c1, c2;
			@Override
			public int compare(String o1, String o2) {
				for(int i = 0; i < len; ++i) {
					c1 = o1.charAt(i); c2 = o2.charAt(i);
					
					if(c1 == c2) continue;
					// 둘다 숫자이거나 둘다 문자일 때
					if( (c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9') 
							||(c1 >= 'A' && c1 <= 'F' && c2 >= 'A' && c2 <= 'F')) {
						return o2.compareTo(o1);
					}
					// 하나는 숫자,하나는 문자일 때
					else {
						if( c1 >= '0' && c1 <= '9') return 1;
						else return -1;
					}
					
				}
				return 0;
			}
		});
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		
			numbers = br.readLine();
			len = N / 4;
			for(int i = 0; i < len; ++i)
				numbers += numbers.charAt(i);
			
			passSet.clear();
			for(int i = 0; i < len; ++i) {
				for(int j = 0; j < 4; ++j) {
					passSet.add(numbers.substring(i + j*len, i + j*len + len));
				}
			}
			
			iter = passSet.iterator();
			for(int i = 0; i < K -1; ++i) iter.next();
			password = iter.next();
			
			System.out.printf("#%d %d\n", tc, Integer.parseInt(password, 16));
			
		}// tc 종료
	}

}
