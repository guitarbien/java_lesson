package java_lesson;

import java.text.DecimalFormat;

public class LessonTwo {
	/*
	 * 隨機產生15個介於1-10之間的浮點數(不能重覆), 將其取至小數第三位並依序存入陣列, 並計算15個數字之總合與平均數 例: 陣列:
	 * 3.412, 6.651, 3.985, 9.557, 1.009, 4.593, 5.002, 9.881, 4.500, 7.909 總合:
	 * 56.5 平均數: 5.650
	 */
	public static void main(String[] args) {
		String[] number = new String[15];
		DecimalFormat df = new DecimalFormat("#.000");

		for (int i = 0; i < 15; i++) {
			String current = df.format(Math.random() * 9 + 1);

//			for (int j = 0; j < number.length; j++) {
//				if (null != number[j] && !number[j].equals(current)){
//					i--;
//					break;
////					System.out.println('A' + j);
//				}
//			}
			
			number[i] = current;
		}

		double sum = 0;
		for (String str : number) {
			sum += Double.parseDouble(str);
		}

		System.out.println("陣列：" + String.join(", ", number));
		System.out.println("總和：" + df.format(sum));
		System.out.println("平均數：" + df.format(sum/15));
	}

}
