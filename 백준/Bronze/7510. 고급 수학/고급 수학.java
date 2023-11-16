import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; ++i) {
			if(i != 1) sb.append("\n\n");
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[3];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			sb.append("Scenario #").append(i).append(":\n");
			if(arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) sb.append("yes");
			else sb.append("no");
		}

		System.out.println(sb);
	}

}