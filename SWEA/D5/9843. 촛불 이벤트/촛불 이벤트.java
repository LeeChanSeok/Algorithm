import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static long N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		long end = 10000000000L;
		for(int tc = 1; tc <= T; ++tc) {
			N = Long.parseLong(br.readLine());
			
			long idx = binarySearch(0, end);
			
			long answer = -1;
			if(N == (idx*(idx+1)/2)) answer = idx;
			
			sb.append("#" + tc + " " + answer + "\n");
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
			
			if((mid*(mid+1)/2) <= N ) {
				s = mid + 1;
				max = mid;
			}else {
				e = mid - 1;
			}
		}
		
		return max;
	}
	
}
