import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static final int DELTA = 10;
	static Map<Character, Integer> c2i;
	static Set<Character> consonant;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		init();
		
		int sl = c2i.get(st.nextToken().charAt(0));
		int sr = c2i.get(st.nextToken().charAt(0));
		
		char[] str = br.readLine().toCharArray();
		
		int pos, dist;
		int answer = 0;
		for(char c : str) {
			pos = c2i.get(c);
			if(consonant.contains(c)) {
				dist = calc_dist(sl, pos);
				answer += dist + 1;
				sl = pos;
			}else {
				dist = calc_dist(sr, pos);
				answer += dist + 1;
				sr = pos;
				
			}
			
		}
		
		System.out.print(answer);
	}
	
	
	private static int calc_dist(int p1, int p2) {
		// TODO Auto-generated method stub
		return Math.abs(p1/DELTA - p2/DELTA) + Math.abs(p1%DELTA - p2%DELTA);
	}

	private static void init() {
		c2i = new HashMap<>();
		consonant = new HashSet<>();
		
		c2i.put('q', 0); c2i.put('w', 1); c2i.put('e', 2); c2i.put('r', 3); c2i.put('t', 4);
		c2i.put('y', 5); c2i.put('u', 6); c2i.put('i', 7); c2i.put('o', 8); c2i.put('p', 9);
		
		c2i.put('a', 10); c2i.put('s', 11); c2i.put('d', 12); c2i.put('f', 13); c2i.put('g', 14);
		c2i.put('h', 15); c2i.put('j', 16); c2i.put('k', 17); c2i.put('l', 18);
		
		c2i.put('z', 20); c2i.put('x', 21); c2i.put('c', 22); c2i.put('v', 23); c2i.put('b', 24);
		c2i.put('n', 25); c2i.put('m', 26); 
	
		consonant.add('q'); consonant.add('w'); consonant.add('e'); consonant.add('r'); consonant.add('t');
		consonant.add('a'); consonant.add('s'); consonant.add('d'); consonant.add('f'); consonant.add('g');
		consonant.add('z'); consonant.add('x'); consonant.add('c'); consonant.add('v'); 
	}

}
