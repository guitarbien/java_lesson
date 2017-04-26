package java_lesson;

import java.text.DecimalFormat;

public class LessonTwo {
	public static void main() {
		String[] number = new String[15];
		 DecimalFormat df = new DecimalFormat( "#.000" );

		for (int i = 0; i < 15; i++) {
			String current = df.format(Math.random() * 9 + 1);

			for (int j = 0; j < i; j++) {
				if (number[j].equals(current)) {
					i--;
					break;
				}
			}

			number[i] = current;
		}

		double sum = 0;
		for (String str : number) {
			sum += Double.parseDouble(str);
		}

		System.out.println("陣列：" + String.join(", ", number));
		System.out.println("總和：" + df.format(sum));
		System.out.println("平均數：" + df.format(sum / 15));
	}

}
