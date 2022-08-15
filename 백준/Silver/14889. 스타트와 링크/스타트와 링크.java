import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, cCnt;
	public static int cnt, idx;
	public static int min;
	public static int[] pickA, pickB;
	public static int[][] memoiz, ability;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		ability = new int[N][N];
		memoiz = new int[N+1][N/2+1];
		pickA = new int[N/2];
		pickB = new int[N/2];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				ability[i][j] = Integer.parseInt(st.nextToken());
		}
		cCnt = combCnt(N, N/2);
		min =Integer.MAX_VALUE;
		combination(0, 0, 0);
		System.out.println(min);
		
	}
	
	public static int calcAbility(int[] player) {
		int res = 0;
		for(int i = 0; i < player.length-1; i++) 
			for(int j = i +1; j< player.length; j++) {
				res += ability[player[i]][player[j]];
				res += ability[player[j]][player[i]];
			}
		
		return res;
	}
	
	public static int diff_Ability(int[] A, int[] B){
		return Math.abs(calcAbility(A) - calcAbility(B));
	}
	
	public static void calc_restPick(int[] pickA, int[] pickB) {
		boolean isContain;
		for(int i = 0, bIdx = 0; bIdx < N/2 && i < N; i++) {
			isContain = false;
			for(int j = 0; j < pickA.length; j++) {
				if(i == pickA[j]) {
					isContain = true;
					break;
				}
			}
			if(isContain) continue;
			pickB[bIdx++] = i;
		}
	}
	
	public static void combination(int idx, int cnt, int contain) {
		if(contain == N/2 || idx == N) {
			if(contain != N/2) return;
			pickB = new int[N/2];
			calc_restPick(pickA, pickB);
			min = Math.min(min, diff_Ability(pickA, pickB));
			return;
		}
		
		pickA[cnt] = idx;
		combination(idx+1, cnt+1, contain+1);
		combination(idx+1, cnt, contain);
	}
	
	public static int combCnt(int n, int r) {
		if(r > n/2) r = n/2;
		if(memoiz[n][r] != 0) return memoiz[n][r];
		
		if(r == 0) return 1;
		else if(r == 1) return n;
		else {
			memoiz[n][r] = combCnt(n-1, r-1) + combCnt(n-1, r);
			return memoiz[n][r];
		}
	}
}