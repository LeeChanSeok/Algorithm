import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static int N;
	static Set<Integer> friends;
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		for(int i = 0; i < N; ++i) {
			arr[i] = br.readLine().toCharArray();
		}

		int max = 0;
		
		for(int i = 0; i < N; ++i) {
			friends = new HashSet<>();
			
			getFriends(i);
			friends.remove(i);
			max = Math.max(max, friends.size());
		}
		System.out.println(max);
	}

	private static void getFriends(int num) {

		for(int i = 0; i < N; ++i) {
			if(num == i) continue;
			
			if(arr[num][i] == 'Y') {
				friends.add(i);

				for(int j = 0; j < N; ++j) {
					if(i == j) continue;
					
					if(arr[i][j] == 'Y') {
						friends.add(j);
						
					}
				}
				
			}
		}
		
	}

}