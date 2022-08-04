import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<>();
		int N = 8;
		int cha;
		int number;
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();			
			st = new StringTokenizer(br.readLine());
			
			q.clear();
			for(int i = 0; i < N; i++)
				q.offer(Integer.parseInt(st.nextToken()));
			
			cha = 0;
			while(true) {
				number = q.poll() - (cha + 1);
				if (number <= 0 ) {
					number = 0;
					q.offer(number);
					break;
				}
				q.offer(number);
				cha = (++cha) % 5;
			}
			
			System.out.print("#"+tc+" ");
			while(!q.isEmpty())
				System.out.print(q.poll() +" ");
			System.out.println();
			
		}
	}

}