package java_lesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class LessonSeven {
	/*
	 * 附檔 encode_file.txt 中有兩行以 UTF-8 編碼的字串，請寫一支程式讀取檔案內容，為字串進行解碼，並將字串依原本的格式寫入另一檔案 (decode_file.txt)。
	 */
	public static void main( String[] args ) {
		StringBuffer encodingStr = readFile( "D:\\encoding.txt" );

		String decodeStr = decoding( encodingStr );

		writeFile( "D:\\encoding_file_here\\decode_ok.txt", decodeStr, true );
		System.out.println( "ok" );
	}

	public static void writeFile( String filepath, String content ) {
		writeFile( filepath, content, false );
	}

	public static void writeFile( String filepath, String content, Boolean useAppend ) {
		try {
			File file = new File( filepath );
			file.getParentFile().mkdirs();
			FileWriter fw = new FileWriter( file, useAppend );

			BufferedWriter bw = new BufferedWriter( fw );

			bw.append( content );

			bw.close();
			fw.close();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String decoding( StringBuffer encodingStr ) {
		String decodeStr = "";

		try {
			decodeStr = URLDecoder.decode( encodingStr.toString(), "UTF-8" );
		} catch ( UnsupportedEncodingException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return decodeStr;
	}

	private static StringBuffer readFile( String filepath ) {
		StringBuffer stringBuffer = new StringBuffer();
		String stringLine = "";

		try {
			FileReader fr = new FileReader( filepath );
			BufferedReader br = new BufferedReader( fr );

			while ( ( stringLine = br.readLine() ) != null ) {
				stringBuffer.append( stringLine.trim() );
			}

			br.close();
			fr.close();
		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stringBuffer;
	}
}
