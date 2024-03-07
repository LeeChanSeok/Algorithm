import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n+1];
		int d[] = new int[n+1];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i <= n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		int max = 0; 
		for(int i = 1; i <= n; i++){
			d[i] = a[i];
			for(int j = 1; j < i; j++)
				if(a[j]<a[i] && d[i] < d[j]+a[i]) d[i] = d[j] + a[i];
			if(max < d[i]) max = d[i];
		}
		System.out.println(max);
	}

}