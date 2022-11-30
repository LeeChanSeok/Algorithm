import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		Arrays.sort(arr, (p1, p2) -> {
			if(p1[0] == p2[0]) return p1[1] - p2[1];
			return p1[0] - p2[0];
		});
		
		for(int[] r : arr)
			System.out.println(r[0] + " " + r[1]);
	}

}