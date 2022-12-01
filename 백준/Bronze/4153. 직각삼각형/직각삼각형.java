import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb  = new StringBuilder();
		StringTokenizer st;
		
		int[] length = new int[3];
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			length[0] = Integer.parseInt(st.nextToken());
			length[1] = Integer.parseInt(st.nextToken());
			length[2] = Integer.parseInt(st.nextToken());
			
			if(length[0] == 0) break;
			
			Arrays.sort(length);
			if(isTriangle(length)) sb.append("right\n");
			else sb.append("wrong\n");
		}

		bw.write(sb.toString());
		bw.close();
	}

	private static boolean isTriangle(int[] length) {
		if(length[0] * length[0] + length[1] * length[1] == length[2] * length[2]) return true;
		return false;
	}

}