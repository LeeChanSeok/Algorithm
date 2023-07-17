import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int nano = 10000000;
	static String s;
	static int x, n;
	static int[] block;
	
	public static void main(String[] args) throws Exception {
		
		while((s = br.readLine()) != null){
			input();
			pro();
		}
		
	}

	private static void pro() {

		int l = 0, r = n - 1;
		boolean flag = false;
		while(l < r) {
			
			int sum = block[l] + block[r];
			
			if(sum > x) --r;
			else if(sum < x) ++l;
			else {
				flag = true;
				break;
			};
		}
		
		if(!flag) System.out.println("danger");
		else System.out.printf("yes %d %d\n", block[l], block[r]); 
		
	}

	private static void input() throws Exception {
		
		x = Integer.parseInt(s) * nano;
		n = Integer.parseInt(br.readLine());
		
		block = new int[n];
		for(int i = 0; i < n; ++i) block[i] = Integer.parseInt(br.readLine());
		Arrays.sort(block);
		
	}

}