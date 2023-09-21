import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int max;
	static String str;
	static int len;
	static boolean[] visited;
	static int[] res;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		len = str.length();
		if(len <= 9) max = len;
		else max = (len - 9) / 2 + 9;
		
		visited = new boolean[max + 1];
		res = new int[max];
		
		recursive(0, 0);

	}

	private static boolean recursive(int idx, int cnt) {

		if(idx == len) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < max; ++i) sb.append(res[i] + " ");
			System.out.println(sb);
			return true;
		}

		int num = Integer.parseInt(str.substring(idx, idx + 1));
		if(num <= max && !visited[num]) {
			visited[num] = true;
			res[cnt] = num;
			if(recursive(idx + 1, cnt + 1)) return true;
			visited[num] = false;
		}
		
		if(idx != len - 1) {
			num = Integer.parseInt(str.substring(idx, idx + 2));
			if(num <= max && !visited[num]) {
				visited[num] = true;
				res[cnt] = num;
				if(recursive(idx + 2, cnt + 1)) return true;
				visited[num] = false;
			}
		}
				
		return false;
	}

}