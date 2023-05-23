import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, p;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			for(int i = 0; i < n; ++i) {
				
				int idx = binarySearch(i, n-1);
				int blank = (arr[idx] - arr[i]) - (idx - i);
				
				int day = arr[idx] - arr[i] + 1;
				if(blank <= p) {
					day += (p - blank);
				}
				
				answer = Math.max(answer, day);
				
			}
			
			sb.append("#" + tc + " " + answer + "\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

	private static int binarySearch(int i, int e) {

		int max = 0;
		int s = 0;
		int mid= 0, blank;
		while(s <= e) {
			mid = (s + e) / 2;
			
			blank = (arr[mid] - arr[i]) - (mid - i);
			
			if(blank <= p) {
				s = mid+1;
				max = mid;
			}else {
				e = mid-1;
			}
			
		}
		
		return max;
	}

}