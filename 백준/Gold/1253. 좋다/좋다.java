import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> numbers = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) 
			numbers.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(numbers);
		
		int ans = 0;
		int s, e, sNum, eNum, num, sum;
		for(int i = 0, numCnt = numbers.size(); i < numCnt; ++i) {
			num = numbers.get(i);
			
			s = 0; e = numCnt-1;
			while(s < e) {
				sNum = numbers.get(s);
				eNum = numbers.get(e);
				sum = sNum + eNum;
				
				if(s == i) ++s;
				else if( e== i) --e;
				else {
					if(sum == num) {
						++ans;
						break;
					}else if(sum < num) {
						++s;
					}else {
						--e;
					}
				}
				
			}
		}
	
		System.out.println(ans);
	}

}
