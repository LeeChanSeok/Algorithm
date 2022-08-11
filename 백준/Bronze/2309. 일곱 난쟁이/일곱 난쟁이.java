import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		int R = 7;
		int[] tall = new int[N];
		int[] comb = new int[N];
		
		for(int i = N-1; i >=N-R ; i--) {
			comb[i] = 1;
		}
		
		for(int i = 0 ; i < N; i++) {
			tall[i] =Integer.parseInt(br.readLine());			
		}
		Arrays.sort(tall);
		
		do {
			if(isSeven(tall, comb)) {
				PrintComb(tall, comb);
				break;
			}
		}while(nextCombination(comb));
		
	}
	
	public static void PrintArr(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");			
		}
		System.out.println();
	}
	public static void PrintComb(int[] tall, int[] comb) {
		for(int i = 0; i < tall.length; i++) {
			if(comb[i] == 1) System.out.println(tall[i]);
		}
	}
	
	
	public static boolean isSeven(int[] tall, int[] comb) {
		int total_tall = 0;
		for(int i = 0; i < tall.length; i++) {
			if(comb[i] == 1) total_tall += tall[i];
		}
		
		if(total_tall == 100) return true;
		else return false;
	}
	
	public static boolean nextCombination(int[] comb) {
		int N = comb.length;
		int i = N-1;
		while(i > 0 && comb[i-1] >= comb[i]) --i;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(comb[i-1] >= comb[j]) --j;
		
		swap(comb, i-1, j);
		
		int k = N-1;
		while(i < k) {
			swap(comb, i++, k--);
		}
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}