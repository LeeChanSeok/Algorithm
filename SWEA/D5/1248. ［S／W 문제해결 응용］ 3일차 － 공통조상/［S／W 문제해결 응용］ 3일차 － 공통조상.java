import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int V, E, v1, v2;
	static int pTree[][], cTree[];
	static List<Integer> v1_p, v2_p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			
			pTree = new int[V+1][2];
			cTree = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(pTree[p][0] == 0) pTree[p][0]= c;
				else pTree[p][1] = c;
				cTree[c] = p;
			}
			
			v1_p = new ArrayList<>(); 
			v2_p = new ArrayList<>();
			
			int parent;
			//v1 parent 찾기
			parent = v1;
			while(parent != 1) {
				v1_p.add(parent);
				parent = cTree[parent];
			}
			
			//v1 parent 찾기
			parent = v2;
			while(parent != 1) {
				v2_p.add(parent);
				parent = cTree[parent];
			}
			
			// 공통 부모 찾기
			int root = 1;
			boolean isFind = false;
			for(int v1p : v1_p) {
				for(int v2p: v2_p) {
					if(v1p == v2p) {
						root = v1p;
						isFind = true;
						break;
					}
				}
				if(isFind) break;
			}
			
			
			int res = 1;
			Queue<Integer> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				if(pTree[cur][0] != 0) {
					q.add(pTree[cur][0]);
					res++;
				}
				
				if(pTree[cur][1] != 0) {
					q.add(pTree[cur][1]);
					res++;
				}
				
			}
			
			
			System.out.println("#" + tc + " " + root + " " + res);
		}//tc종료
		
	}

}