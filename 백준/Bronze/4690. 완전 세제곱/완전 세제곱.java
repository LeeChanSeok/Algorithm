public class Main {

	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();

		int tA, tB, tC, tD;
		int sum;
		for (int a = 2; a <= 100; ++a) {
			tA = a * a * a;
			for (int b = 2; b <= a; ++b) {
				tB = b * b * b;
				
				for (int c = b; c <= a; ++c) {
					tC = c * c * c;
					
					for (int d = c; d <= a; ++d) {
						tD = d * d * d;
						sum = tB + tC + tD;
						
						if(tA == sum) sb.append(String.format("Cube = %d, Triple = (%d,%d,%d)\n", a, b, c, d));
					}
				}
			}
		}
		
		System.out.println(sb);
	}

}