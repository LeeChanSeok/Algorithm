import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int[] input = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int sum;
		for(int flag = 1, caseCnt = 1 <<N; flag < caseCnt; flag++) {
			sum = 0;
			for(int i = 0; i < N; i++) {
				if((flag & (1 << i)) != 0) {
					sum += input[i];
				}
			}
			if(sum == S) cnt++;
		}
		System.out.println(cnt);
	}

}