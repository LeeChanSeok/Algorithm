import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			parents = new int[N+1];
			
			for(int i = 1; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				parents[B] = A;
			}
			
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int common = find_common_parent(x, y);
			sb.append(common).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();

	}

	private static int find_common_parent(int x, int y) {

		List<Integer> xP = new ArrayList<>();
		xP.add(x);
		while(parents[x] != 0) {
			xP.add(parents[x]);
			x = parents[x];
		}
		
		List<Integer> yP = new ArrayList<>();
		yP.add(y);
		while(parents[y] != 0) {
			yP.add(parents[y]);
			y = parents[y];
		}
		
		int xIdx = xP.size()-1;
		int yIdx = yP.size()-1;
		
		while(xIdx >= 0 && yIdx >= 0) {
			if((int)xP.get(xIdx) != (int)yP.get(yIdx)) return xP.get(xIdx+1);
			--xIdx;
			--yIdx;
		}
				
		return xP.get(xIdx+1);
	}

}