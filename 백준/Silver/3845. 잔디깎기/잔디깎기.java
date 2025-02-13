import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String s = "";
		
		int nx, ny;
		double w, now;
		boolean check;
		List<Double> arr;
		StringTokenizer st;
		
		while (!(s = br.readLine()).equals("0 0 0.0")) {
			st = new StringTokenizer(s);
			nx = Integer.parseInt(st.nextToken());
			ny = Integer.parseInt(st.nextToken());
			w = Double.parseDouble(st.nextToken());
			
			check = true;
			arr = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < nx; i++) {
				arr.add(Double.parseDouble(st.nextToken()));
			}
			
			Collections.sort(arr);
			
			now = 0;
			for (int i = 0; i < nx; i++) {
				if (arr.get(i) - (w / 2) <= now) {
					now = arr.get(i) + (w / 2);
				} else {
					check = false;
					break;
				}
			}
			
			if (!check || now < 75) {
				br.readLine();
				sb.append("NO\n");
				continue;
			}
			
			arr = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < ny; i++) {
				arr.add(Double.parseDouble(st.nextToken()));
			}
			
			Collections.sort(arr);
			
			now = 0;
			for (int i = 0; i < ny; i++) {
				if (arr.get(i) - (w / 2) <= now) {
					now = arr.get(i) + (w / 2);
				} else { 
					check = false;
					break;
				}
			}
			
			if (!check || now < 100) {
				sb.append("NO\n");
			} else {
				sb.append("YES\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}