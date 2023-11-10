import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] r = new int[3];
		r[0] = Integer.parseInt(st.nextToken());
		r[1] = Integer.parseInt(st.nextToken());
		r[2] = Integer.parseInt(st.nextToken());

		Arrays.sort(r);
		
		if(r[0] + r[1] <= r[2]) r[2] = r[0] + r[1] - 1;
				
		System.out.println(r[0] + r[1] + r[2]);
		
	}

}