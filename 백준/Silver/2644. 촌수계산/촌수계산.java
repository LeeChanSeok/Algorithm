import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		int x = 0, y = 0;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			parent[y] = x;
		}
		
		LinkedList<Integer> listA = new LinkedList<>();
		findRootPath(listA, a);
		
		LinkedList<Integer> listB = new LinkedList<>();
		findRootPath(listB, b);
		
		ListIterator<Integer> iterA = listA.listIterator();
		ListIterator<Integer> iterB = listB.listIterator();
		
		int cnt = 0;
		while(iterA.hasNext() && iterB.hasNext()) {
			if(iterA.next() != iterB.next()) break;
			++cnt; 
		}
		
		int answer = -1;
		if(cnt != 0) answer = (listA.size() + listB.size() - cnt*2);
		
		System.out.println(answer);
		
	}

	private static void findRootPath(LinkedList<Integer> list, int n) {

		while(n != 0) {
			list.addFirst(n);
			n = parent[n];
		}
		
	}

}