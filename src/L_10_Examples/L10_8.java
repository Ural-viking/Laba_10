package L_10_Examples;

/* Прочитать и вывести на экран информацию из трех источников: файла
на диске, интернет-страницы и массива данных типа byte. Указать кодировку,
поддерживающую кириллицу. */

import java.io.*;
import java.net.*;

public class L10_8 {
	
	public static void readAllByByte(Reader in) throws IOException{
		while(true) {
			int oneByte = in.read();
			if(oneByte != -1) {
				System.out.print((char)oneByte);
			}
			else {
				System.out.print("\n" + "конец");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			// С потоком связан файл
			InputStream inFile = new FileInputStream("C:\\Papka1\\MyFile.txt");
			Reader rFile = new InputStreamReader(inFile,"cp1251");
			readAllByByte(rFile);
			System.out.print("\n\n\n");
			inFile.close();
			rFile.close();
			InputStream inUrl = (new URL("http://google.com")).openStream();
            Reader rUrl = new InputStreamReader(inUrl, "cp1251");
            readAllByByte(rUrl);
            System.out.print("\n\n\n");
            inUrl.close();
            rUrl.close();
            InputStream inArray = new ByteArrayInputStream(new byte[]{5, 8, 3, 9, 11});
            Reader rArray = new InputStreamReader(inArray, "cp1251");
            readAllByByte(rArray);
            System.out.print("\n\n\n");
            inArray.close();
            rArray.close();
		}
		catch(IOException e) {
			System.out.println("Ошибка: " + e);
		}
	}

}