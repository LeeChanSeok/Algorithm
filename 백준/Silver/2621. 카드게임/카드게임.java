import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static class Card {
		char color;
		int number;

		public Card(char color, int number) {
			super();
			this.color = color;
			this.number = number;
		}
	}

	static Card[] cards = new Card[5];
	static Map<Character, Integer> cMap;
	static Map<Integer, Integer> nMap;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		char color;
		int number;

		cMap = new HashMap<>();
		nMap = new TreeMap<>();

		for (int i = 0; i < 5; ++i) {
			st = new StringTokenizer(br.readLine());

			color = st.nextToken().charAt(0);
			number = Integer.parseInt(st.nextToken());

			cards[i] = new Card(color, number);

			cMap.put(color, cMap.getOrDefault(color, 0) + 1);
			nMap.put(number, nMap.getOrDefault(number, 0) + 1);
		}
		
		Arrays.sort(cards, (c1, c2) -> c1.number - c2.number);
		
		boolean isContinuos = checkContinuous();
		String cKey = colorRule();
		String nKey = numberRule();

		int score = applyRule(isContinuos, cKey, nKey);
		
		System.out.println(score);

	}


	private static int applyRule(boolean isContinuos, String cKey, String nKey) {
		int score = 0;
		// 1. 카드 5장이 모두 같은 색이면서 숫자가 연속적일 때, 점수는 가장 높은 숫자에 900을 더한다. 예를 들어, 카드가 Y4, Y3, Y2,
		// Y5, Y6 일 때 점수는 906(=6+900)점이다.
		if(cKey.equals("5") && isContinuos) {
			score = 900 + cards[4].number;
		}
		
		// 2. 카드 5장 중 4장의 숫자가 같을 때 점수는 같은 숫자에 800을 더한다. 예를 들어, 카드가 B3, R3, B7, Y3, G3 일 때
		//점수는 803(=3+800)점이다.
		else if(nKey.equals("41")) {
			score = 800 + getNumber(4);
		}
		
		// 3. 카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때 점수는 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음
		// 700을 더한다. 예를 들어, 카드가 R5, Y5, G7, B5, Y7 일 때 점수는 757(=5x10+7+700)점이다.
		else if(nKey.equals("32")) {
			score = getNumber(3) * 10 + getNumber(2) + 700;
		}
		
		// 4. 5장의 카드 색깔이 모두 같을 때 점수는 가장 높은 숫자에 600을 더한다. 예를 들어, 카드가 Y3, Y4, Y8, Y6, Y7 일 때
		// 점수는 608(=8+600)점이다.
		else if(cKey.equals("5")) {
			score = 600 + cards[4].number;
		}
		// 5. 카드 5장의 숫자가 연속적일 때 점수는 가장 높은 숫자에 500을 더한다. 예를 들어 R7, R8, G9, Y6, B5 일 때 점수는
		// 509(=9+500)점이다.
		else if(isContinuos) {
			score = 500 + cards[4].number;
		}
		
		// 6 .카드 5장 중 3장의 숫자가 같을 때 점수는 같은 숫자에 400을 더한다. 예를 들어 R7, Y7, R2, G7, R5 일 때 점수는
		// 407(=7+400)점이다.
		else if(nKey.equals("311")) {
			score = 400 + getNumber(3);
		}
		// 7. 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 점수는 같은 숫자 중 큰 숫자에 10을 곱하고 같은 숫자 중 작은 숫자를
		// 더한 다음 300을 더한다. 예를 들어, R5, Y5, Y4, G9, B4 일 때 점수는 354(=5X10+4+300)점이다.
		else if(nKey.equals("221")) {
			int score2 = getNumber(2);
			score = score2 % 10 * 10 + score2 / 10 + 300;
		}
		// 8. 카드 5장 중 2장의 숫자가 같을 때 점수는 같은 숫자에 200을 더한다. 예를 들어, R5, Y2, B5, B3, G4 일 때 점수는
		// 205(=5+200)점이다.
		else if(nKey.equals("2111")) {
			score = 200 + getNumber(2);
		}
		
		// 9. 위의 어떤 경우에도 해당하지 않을 때 점수는 가장 큰 숫자에 100을 더한다. 예를 들어, R1, R2, B4, B8, Y5 일 때 점수는
		// 108(=8+100)점이다.
		else {
			score = 100 + cards[4].number;
		}
		
		return score;
	}

	private static int getNumber(int cnt) {
		
		int score = 0;
		for(Entry<Integer, Integer> entry : nMap.entrySet()) {
			if(entry.getValue() == cnt) score = score * 10 + entry.getKey();
		}
		
		return score;
	}


	private static String numberRule() {
		String str = "";

		List<Integer> list = new LinkedList<>();
		for (Entry<Integer, Integer> entry : nMap.entrySet()) {
			list.add(entry.getValue());
		}

		Collections.sort(list, (l1, l2) -> l2 - l1);
		for (int cnt : list)
			str += cnt;

		return str;

	}
	
	private static String colorRule() {

		String str = "";

		List<Integer> list = new LinkedList<>();
		for (Entry<Character, Integer> entry : cMap.entrySet()) {
			list.add(entry.getValue());
		}

		Collections.sort(list, (l1, l2) -> l2 - l1);
		for (int cnt : list)
			str += cnt;

		return str;
	}

	private static boolean checkContinuous() {

		int prev = 0;
		for (Card card : cards) {
			if (prev != 0 && prev + 1 != card.number)
				return false;
			prev = card.number;
		}

		return true;
	}

}