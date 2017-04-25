package java_lesson;

public class LessonOne {
	/*
	 * 模擬1粒骰子投擲20次(隨機)，並統計點數總和出現的次數, 將結果以數字印出. 例: 執行結束, 列出結果為: 1 :3次 2 :8次 3 :6次
	 * 4 :3次 5 :3次 6 :3次
	 */
	public static void main(String[] args) {

		int num1, num2, num3, num4, num5, num6;
		num1 = num2 = num3 = num4 = num5 = num6 = 0;

		for (int i = 1; i <= 20; i++) {
			int current = (int) (Math.random() * 6 + 1);

			switch (current) {
			case 1:
				num1 += 1;
				break;
			case 2:
				num2 += 1;
				break;
			case 3:
				num3 += 1;
				break;
			case 4:
				num4 += 1;
				break;
			case 5:
				num5 += 1;
				break;
			case 6:
				num6 += 1;
				break;
			default:
				break;
			}

		}

		System.out.println("1 :" + num1 + "次");
		System.out.println("2 :" + num2 + "次");
		System.out.println("3 :" + num3 + "次");
		System.out.println("4 :" + num4 + "次");
		System.out.println("5 :" + num5 + "次");
		System.out.println("6 :" + num6 + "次");
	}

}
