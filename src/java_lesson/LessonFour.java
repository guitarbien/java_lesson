package java_lesson;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LessonFour {
	/*
	 * 隨機產生15個介於1-10之間的BigDecimal(不能重覆), 將其取至小數第三位(四捨五入)並依序存入Collection類物件, 並進行下列計算: (1). 印出其排序後之數列 (2). 計算15個數字之平均值 例: 排序後: 1.009, 3.412, 3.985, 4.500, 4.593, 5.002, 6.651, 7.909, 9.557, 9.881 平均數:
	 * 5.650
	 */
	public static void main( String[] args ) {
		DecimalFormat df = new DecimalFormat( "#.000" );
		List<BigDecimal> collect = new ArrayList<BigDecimal>();

		for ( int i = 1; i <= 15; i++ ) {
			collect.add( new BigDecimal( df.format( Math.random() * 9 + 1 ) ) );
		}

		Collections.sort( collect );

		BigDecimal sum = new BigDecimal( 0 );
		String chain = "";

		for ( int i = 0; i < collect.size(); i++ ) {
			BigDecimal current = collect.get( i );

			sum = sum.add( current );

			chain += current.toString();

			if ( i < collect.size() - 1 ) {
				chain += ", ";
			}
		}

		System.out.println( sum );
		System.out.println( "排序後：" + chain );
		System.out.println( "平均數：" + sum.divide( new BigDecimal( "15" ), 3, BigDecimal.ROUND_HALF_UP ) );
	}

}
