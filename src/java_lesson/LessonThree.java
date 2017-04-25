package java_lesson;

import java.util.HashMap;
import java.util.Map;

public class LessonThree {
	/*
	 * 模擬3粒骰子投擲100次(隨機)，並統計點數總和出現的次數, 將結果以*印出. 請改以Map類物件來撰寫。(次數為0的不用印出) 例: 執行結束,
	 * 列出結果為: 3 *** 4 ***
	 */
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 3; i <= 18; i++) {
			map.put(i, 0);
		}

		for (int i = 1; i <= 100; i++) {
			int current = diceThreeTimes();
			int keep = map.get(current);
			map.put(current, keep + 1);
		}

		for (int i : map.keySet()) {
			int sum = map.get(i);
			if (sum <= 0) {
				continue;
			}

			String star = "";

			for (int j = 1; j <= sum; j++) {
				star += "*";
			}

			System.out.println(i + star);
		}
	}

	private static int dice() {
		return (int) (Math.random() * 6 + 1);
	}

	private static int diceThreeTimes() {
		return dice() + dice() + dice();
	}
}
