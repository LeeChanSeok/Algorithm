import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] mod = {15, 28, 19};
		
		int E = Integer.parseInt(st.nextToken())-1;
		int S = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(st.nextToken())-1;
		int[] Time = {E, S, M};
		
		int i = 0;
		boolean isFind;
		while(true) {
			isFind = true;
			for(int j = 0; j < 3; j++) {
				if (i % mod[j] != Time[j]) {
					isFind = false;
					break;
				}
			}
			if(isFind) break;
			i++;
		}
		System.out.println(++i);
	}

}
