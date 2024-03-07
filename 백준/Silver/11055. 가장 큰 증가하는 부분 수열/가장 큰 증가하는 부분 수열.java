import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j;
		int n=sc.nextInt();
		int a[] = new int[n+1];
		int d[] = new int[n+1];
		
		int max = 0; 
		
		for(i=1;i<=n;i++) a[i] = sc.nextInt();
		
		for(i=1;i<=n;i++){
			d[i] = a[i];
			for(j=1;j<i;j++)
				if(a[j]<a[i] && d[i] < d[j]+a[i]) d[i] = d[j] + a[i];
			if(max < d[i]) max = d[i];
		}
		System.out.println(max);
	}

}