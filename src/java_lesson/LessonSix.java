package java_lesson;

import java.util.Calendar;
import java.util.Scanner;

public class LessonSix {
	/*
	 * 輸入介於1-12間的整數m, 並運用java 的 Date, Calendar等類別列印出今年m月的月曆. 例:輸入7, 輸出結果為:
	 */

	// 2008年7月
	// ====================
	// 日 一 二 三 四 五 六
	// --------------------
	// 1 2 3 4 5
	// 6 7 8 9 10 11 12
	// 13 14 15 16 17 18 19
	// 20 21 22 23 24 25 26
	// 27 28 29 30 31

	private static Scanner scanner;

	public static void main( String[] args ) {
		scanner = new Scanner( System.in );

		System.out.println( "請輸入：" );

		int input = scanner.nextInt();
		int targetMonth = input - 1;

		Calendar calendar = Calendar.getInstance();
		calendar.set( Calendar.MONTH, targetMonth );
		// 該月有幾天
		int date = calendar.getActualMaximum( Calendar.DATE );

		calendar.set( Calendar.DATE, 1 );
		// 該月1號星期幾
		int weekDay = calendar.get( Calendar.DAY_OF_WEEK );
		// 要補幾個空白
		int space = ( 7 - ( 7 - weekDay + 1 ) );

		String[] array = new String[ ( date + space ) ];

		for ( int i = 0; i < space; i++ ) {
			array[ i ] = " ";
		}

		int day = 1;
		for ( int i = space; i < array.length; i++ ) {
			array[ i ] = String.valueOf( day );
			day += 1;
		}

		System.out.println( "======================" );
		System.out.print( String.format( "%7s", "日" ) );
		System.out.print( String.format( "%7s", "一" ) );
		System.out.print( String.format( "%7s", "二" ) );
		System.out.print( String.format( "%7s", "三" ) );
		System.out.print( String.format( "%7s", "四" ) );
		System.out.print( String.format( "%7s", "五" ) );
		System.out.println( String.format( "%7s", "六" ) );
		System.out.println( "----------------------" );

		for ( int i = 0; i < array.length; i++ ) {
			System.out.print( String.format( "%3s", array[ i ] ) );

			// 換行
			if ( ( i % 7 ) == 6 ) {
				System.out.println( "" );
			}
		}
	}
}
