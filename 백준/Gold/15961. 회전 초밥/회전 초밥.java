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
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int max = 0;
		int[] sushi = new int[D+1];
		
		int[] numbers = new int[N];
		for(int i = 0; i < N; ++i)
			numbers[i] = Integer.parseInt(br.readLine());
		
		int num, cnt = 0;
		for(int i = 0; i < K; ++i) {
			num = numbers[i];
			
			if(sushi[num] == 0) ++cnt;
			++sushi[num];
		}
		
		int addC = 0;
		if(sushi[C] == 0) addC = 1;
		max = Math.max(max, cnt + addC);
		
		for(int i = 1; i < N; ++i) {
			num = numbers[i-1];
			// 이전 초밥 빼기
			if(sushi[num] == 1) --cnt;
			--sushi[num];
			
			// 다음 초밥 넣기
			num = numbers[(i + K - 1) % N];
			if(sushi[num] == 0) ++cnt;
			++sushi[num];
			
			//개수 비교
			addC = 0;
			if(sushi[C] == 0) addC = 1;
			max = Math.max(max, cnt + addC);
		}
		
		System.out.println(max);

	}

}