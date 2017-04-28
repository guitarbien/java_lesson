package java_lesson;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LessonEight {
	/*
	 * 一筆資料轉存成一個Map，並將所有資料放入List中並 利用Collections類別的sort方法，針對Price這個欄位進行 資料排序後輸出成另一份檔案, ex: cars2.csv 。 例如： Manufacturer TYPE Min.PRICE Price Cadillac Midsize 37.5 40.1 Chevrolet Sporty 34.6 38 Audi
	 * Midsize 30.8 37.7 …. 針對Manufacturer這個欄位將資料分組，並計算Min.Price ,Price這兩個欄位的小計、合計並輸出在螢幕上。 例如： Manufacturer TYPE Min.PRICE Price Audi Midsize 30.8 37.7 Audi Midsize 25.9 29.1 小計 56.7 66.8 …… 合計
	 * 所有資料的合計值 所有資料的合計值
	 */
	private List<Car> cars;

	private List<String> title;

	public static void one( LessonEight lessonEight ) {
		// -------------------
		// sort by price asc
		// -------------------
		List<Car> cars = lessonEight.getCars();
		cars.sort( ( c1, c2 ) -> Math.round( c1.getPrice() - c2.getPrice() ) );

		// ---------------
		// build result
		// ---------------
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append( String.join( ",", lessonEight.getTitle() ) );
		stringBuffer.append( "\r\n" );

		for ( int i = 0; i < lessonEight.getCars().size(); i++ ) {
			stringBuffer.append( lessonEight.getCars().get( i ).getManufacturer() );
			stringBuffer.append( "," );
			stringBuffer.append( lessonEight.getCars().get( i ).getType() );
			stringBuffer.append( "," );
			stringBuffer.append( lessonEight.getCars().get( i ).getMinPrice() );
			stringBuffer.append( "," );
			stringBuffer.append( lessonEight.getCars().get( i ).getPrice() );
			stringBuffer.append( "\r\n" );
		}

		// ---------------
		// save new file
		// ---------------
		LessonSeven.writeFile( "D:\\cars2.csv", stringBuffer.toString() );
	}

	public static void two( LessonEight lessonEight ) {
		List<Car> cars = lessonEight.getCars();

		Map<String, List<Car>> group = cars.stream().collect( Collectors.groupingBy( Car::getManufacturer ) );

		BigDecimal sumMinPrice = new BigDecimal( 0 );
		BigDecimal sumPrice = new BigDecimal( 0 );
		BigDecimal groupMinPrice = new BigDecimal( 0 );
		BigDecimal groupPrice = new BigDecimal( 0 );
		String lastManufacturer = "";
		for ( String key : group.keySet() ) {

			for ( int i = 0; i < group.get( key ).size(); i++ ) {

				if ( !lastManufacturer.equals( "" ) && !lastManufacturer.equals( key ) ) {
					System.out.print( String.format( "%8s", "===== 小計  -------------" ) );
					System.out.print( String.format( "%8s", groupMinPrice.setScale( 3, BigDecimal.ROUND_HALF_UP ) ) );
					System.out.print( String.format( "%10s", groupPrice.setScale( 3, BigDecimal.ROUND_HALF_UP ) ) );

					System.out.print( " ==========" );
					System.out.println( "" );
					groupMinPrice = new BigDecimal( 0 );
					groupPrice = new BigDecimal( 0 );
				}

				float minPrice = group.get( key ).get( i ).getMinPrice();
				float price = group.get( key ).get( i ).getPrice();

				sumMinPrice = sumMinPrice.add( new BigDecimal( minPrice ) );
				sumPrice = sumPrice.add( new BigDecimal( price ) );
				groupMinPrice = groupMinPrice.add( new BigDecimal( minPrice ) );
				groupPrice = groupPrice.add( new BigDecimal( price ) );

				System.out.print( String.format( "%10s", key ) );
				System.out.print( String.format( "%10s", group.get( key ).get( i ).getType() ) );
				System.out.print( String.format( "%10s", minPrice ) );
				System.out.print( String.format( "%10s", price ) );
				System.out.println( "" );

				lastManufacturer = key;
			}
		}

		System.out.println( "=========================================" );
		System.out.print( String.format( "%30s", sumMinPrice.setScale( 3, BigDecimal.ROUND_HALF_UP ) ) );
		System.out.print( String.format( "%10s", sumPrice.setScale( 3, BigDecimal.ROUND_HALF_UP ) ) );
	}

	public static void main( String[] args ) {

		LessonEight lessonEight = new LessonEight();

		lessonEight.readCarsData( "D:\\cars.csv" );

		one( lessonEight );
		two( lessonEight );
	}

	public void readCarsData( String filepath ) {
		ArrayList<Car> cars = new ArrayList<Car>();

		try {
			// read csv file each line into a Map
			Scanner scan = new Scanner( new File( filepath ) );

			int lineCnt = 0;
			while ( scan.hasNextLine() ) {
				String eachRow = scan.nextLine();

				String[] columns = eachRow.split( "," );

				// skip title
				lineCnt += 1;
				if ( lineCnt == 1 ) {
					this.title = Arrays.asList( columns );
					continue;
				}

				// save each row data to ArrayList
				cars.add( new Car( columns[ 0 ], columns[ 1 ], Float.parseFloat( columns[ 2 ] ), Float.parseFloat( columns[ 3 ] ) ) );
			}

			scan.close();
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		}

		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<String> getTitle() {
		return title;
	}
}
