import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[3];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			String res = "invalid!";
			
			if(arr[0] + arr[1] <= arr[2]) res = "invalid!";
			else if(arr[0] == arr[1] && arr[0] == arr[2])  res = "equilateral";			
			else if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) res = "isosceles";
			else  res = "scalene";
			
				
			sb.append("Case #").append(i).append(": "+res).append('\n');
		}
		System.out.println(sb);
	}

}
