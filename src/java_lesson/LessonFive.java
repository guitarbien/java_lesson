package java_lesson;

public class LessonFive {

	private static String strNormal;

	/*
	 * 請分別以(1) String (2) StringBuffer兩種方法產生一字串”a”，並分別串接另一字串”0” (1) 一萬次 (2) 五萬次 (3)十萬次，最後輸出花費的時間以及記憶體使用量。 Hint1: 獲取記憶體用量的方法可參考Runtime類別。 Hint2: 取得時間的方法可參考System類別。
	 */
	public static void main( String[] args ) {
		int[] timesAry = { 10000, 50000, 100000 };

		for ( int times = 0; times <= 2; times++ ) {
			setStrNormal( "a" );
			long startMem = memUsage();
			long startDt = System.currentTimeMillis();

			for ( int i = 1; i <= timesAry[ times ]; i++ ) {
				setStrNormal( getStrNormal() + "0" );
			}

			long memUsage = memUsage() - startMem;
			long timeCost = System.currentTimeMillis() - startDt;

			System.out.println( "使用 String 串接字串" + timesAry[ times ] + "次, 花費 " + timeCost + " 毫秒, memory: " + ( memUsage / 1024 ) + " KB" );
		}

		for ( int times = 0; times <= 2; times++ ) {
			StringBuffer strBuff = new StringBuffer( "a" );
			long startMem = memUsage();
			long startDt = System.currentTimeMillis();

			for ( int i = 1; i <= timesAry[ times ]; i++ ) {
				strBuff.append( "0" );
			}

			long memUsage = memUsage() - startMem;
			long timeCost = System.currentTimeMillis() - startDt;

			System.out.println( "使用 StringBuffer 串接字串" + timesAry[ times ] + "次, 花費 " + timeCost + " 毫秒, memory: " + ( memUsage / 1024 ) + " KB" );
		}

	}

	private static long memUsage() {
		return ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() );
	}

	public static String getStrNormal() {
		return strNormal;
	}

	public static void setStrNormal( String strNormal ) {
		LessonFive.strNormal = strNormal;
	}
}
