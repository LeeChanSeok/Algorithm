import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	 	static int n;
	    static int[] arr, LIS;

	    public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        StringTokenizer st;

	        n = Integer.parseInt(br.readLine());
	        arr = new int[n];

	        st = new StringTokenizer(br.readLine());
	        for(int i = 0; i < n; ++i){
	            arr[i] = Integer.parseInt(st.nextToken());
	        }

	        LIS = new int[n];
	        LIS[0] = arr[0];
	        int j = 0;
	        int[] idxArr = new int[n];
	        	
	        for(int i = 1; i < n; ++i){

	            if(arr[i] > LIS[j]){
	                LIS[++j] = arr[i];
	                idxArr[i] = j;
	            }else{
	                int idx = binarySearch(0, j, arr[i]);
	                LIS[idx] = arr[i];
	                idxArr[i] = idx;
	            }

	        }

	        sb.append(j+1).append('\n');
	        Stack<Integer> stack = new Stack<>();
	        for(int i = n -1; i >= 0; --i) {
	        	if(idxArr[i] == j) {
	        		stack.push(arr[i]);
	        		--j;
	        	}
	        }
	        while(!stack.isEmpty()) {
	        	sb.append(stack.pop() + " ");
	        }
	        System.out.println(sb);
	    }

	    private static int binarySearch(int l, int r, int target) {

	        while(l < r){
	            int mid = (l + r) / 2;

	            if(LIS[mid] < target){
	                l = mid + 1;
	            } else {
	                r = mid;
	            }
	        }

	        return r;
	    }
}