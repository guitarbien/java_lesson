package java_lesson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LessonEight {
	/*
	 * 一筆資料轉存成一個Map，並將所有資料放入List中並 利用Collections類別的sort方法，針對Price這個欄位進行
	 * 資料排序後輸出成另一份檔案, ex: cars2.csv 。
	 * 
	 * 例如： Manufacturer TYPE Min.PRICE Price Cadillac Midsize 37.5 40.1
	 * Chevrolet Sporty 34.6 38 Audi Midsize 30.8 37.7 ….
	 * 
	 * 
	 * 針對Manufacturer這個欄位將資料分組，並計算Min.Price ,Price這兩個欄位的小計、合計並輸出在螢幕上。 例如：
	 * Manufacturer TYPE Min.PRICE Price Audi Midsize 30.8 37.7 Audi Midsize
	 * 25.9 29.1 小計 56.7 66.8 ……
	 * 
	 * 合計 所有資料的合計值 所有資料的合計值
	 */
	public static void main(String[] args) {
		try {
			// read csv file each line into a Map
			Scanner scan = new Scanner(new File("/Users/bien/Downloads/＜新進人員作業＞/cars.csv"));

			int lineCnt = 0;
			List<String> title = new ArrayList<String>();
			while (scan.hasNextLine()) {
				String eachRow = scan.nextLine();

				String[] columns = eachRow.split(",");

				// --------------------
				// save column title
				// --------------------
				lineCnt += 1;
				if (lineCnt == 1) {
					title = new ArrayList<String>(Arrays.asList(columns));
					continue;
				}

				// -------------------------------
				// save each row data to HashMap
				// -------------------------------
				Map<String, String> row = new HashMap<String, String>();

				for (int i = 0; i < columns.length; i++) {
					row.put(title.get(i), columns[i]);
				}
			}

			scan.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
