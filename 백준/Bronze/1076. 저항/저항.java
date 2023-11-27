import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] color = new String[3];
		
		color[0] = br.readLine();
		color[1] = br.readLine();
		color[2] = br.readLine();
		
		Map<String, int[]> registor = new HashMap<>();
		String[] colors = {"black", "brown", "red", "orange","yellow", "green", "blue","violet", "grey","white"};
		
		for(int v = 0, x = 1, size = colors.length; v < size; ++v, x *= 10) {
			registor.put(colors[v], new int[] {v, x});
		}

		
		long res = (registor.get(color[0])[0] * 10l + registor.get(color[1])[0]) * registor.get(color[2])[1] ;
		System.out.println(res);
		
	}

}