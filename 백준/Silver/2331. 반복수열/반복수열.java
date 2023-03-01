import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int[][] pow = new int[10][6];
		for(int i = 1; i < 10; ++i ) {
			pow[i][1] = i;
			for(int j = 2; j <= 5; ++j) {
				pow[i][j] = i * pow[i][j-1]; 
			}
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int cnt = 0;
		int num, answer;
		num = A;
		do {
			map.put(num, cnt++);
			answer = 0;

			while(num != 0) {
				answer += pow[num % 10][P];
				num /= 10;
			}
			num = answer;
			
		}while(!map.containsKey(num));
		System.out.println(map.get(num));
		
	}

}
