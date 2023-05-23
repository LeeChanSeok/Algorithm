import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static long M;
	
	static Long[] candies;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Long.parseLong(st.nextToken());
		
			candies = new Long[N];
			long max_candy = 0;
			long candy;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				
				candy = Long.parseLong(st.nextToken());
				candies[i] = candy;
				max_candy = Math.max(max_candy, candy);
			}
			Arrays.sort(candies, Collections.reverseOrder());
			
			long bags = binarySearch(1, max_candy);
			
			sb.append("#" + tc + " " + bags + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}
	
	private static long binarySearch(long s, long e) {

		long max = 0;
		while(s <= e) {
			long mid = (s + e) / 2;
			
			long total = 0;
			long count = 0;
			for(int i = 0; i < N; ++i) {
				count = candies[i] / mid;
				total += count;
				if(count == 0 || total >= M) break;
			}
			
			if(total >= M) {
				max = mid;
				s = mid + 1;
			}else {
				e = mid-1;
			}
			
		}
		return max;
	}

}
