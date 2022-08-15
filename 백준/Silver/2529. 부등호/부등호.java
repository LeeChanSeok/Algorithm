import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N, K;
	public static char[] equalSign, pick;
	public static char[] max, min;
	
	public static int charCompare(char[] A, char[] B) {
		for(int i = 0; i < A.length; i++) {
			if(A[i] - B[i] == 0) continue;
			else if(A[i] - B [i] > 0) return 1;
			else return -1;
		}
		return 0;
	}
	
	public static void permutation(int cnt, int flag) {
		if(cnt == K+1) {
			if(charCompare(pick, max) == 1) max = Arrays.copyOf(pick, K+1);
			if(charCompare(pick, min) == -1) min = Arrays.copyOf(pick, K+1);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			char cNum = (char)(i + '0');
			if( (equalSign[cnt-1] == '<' &&  pick[cnt-1] < cNum) ||
					(equalSign[cnt-1] == '>' &&  pick[cnt-1] > cNum)) {
				pick[cnt] = cNum;
				permutation(cnt+1, flag | 1 << i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		K = Integer.parseInt(br.readLine());
		N = 10;
		
		equalSign = new char[K];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++)
			equalSign[i] = st.nextToken().charAt(0);
		
		pick = new char[K+1];
		
		max = new char[K+1];
		min = new char[K+1];
		for(int i = 0; i <K; i++) {
			max[i] = '0';
			min[i] = '9';
		}
		for(int i = 0; i < N; i++) {
			pick[0] = (char)(i + '0');
			permutation(1, 1 << i);
		}

		sb.append(new String(max)).append("\n");
		sb.append(new String(min));
		System.out.println(sb);
	}

}