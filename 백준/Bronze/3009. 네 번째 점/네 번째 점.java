import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] point;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		point = new int[4][2];
		
		for(int i = 0; i < 3; ++i) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		getPoint(0);
		getPoint(1);
		
		System.out.println(point[3][0] + " " + point[3][1]);
		
	}

	private static void getPoint(int v) {

		if(point[0][v] == point[1][v]) point[3][v] = point[2][v];
		else if(point[0][v] == point[2][v]) point[3][v] = point[1][v];
		else point[3][v] = point[0][v];
		
	}

}