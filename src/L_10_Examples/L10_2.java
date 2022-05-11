package L_10_Examples;

			/* Прочитать и вывести на экран информацию из трех источников: 
					- файла на диске;
					- интернет-страницы;
					- массива типа byte. */

import java.io.*;
import java.net.*;

public class L10_2 {
	
// Метод для чтения данных из потока по байтам с выводом
	public static void readAllByByte (InputStream in) throws IOException {
		while(true) {
			int oneByte = in.read(); // читает 1 байт
			if(oneByte != -1) {      // признак отсутствия конца файла
				System.out.print((char)oneByte);
			}
			else {
				System.out.print("\n" + "end");
				break;
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		try {
			
			// С потоком связан файл
			InputStream inFile = new FileInputStream("MyFile.txt"); // используем класс InputStream, создаем обьект этого класса и указываем ссылку на файл необходимый для чтения
			readAllByByte(inFile); // используем метод readAllByByte
			System.out.print("\n\n\n"); 
			inFile.close(); // используем метод close для закрытия файла
			
			// С потоком связана интернет-страница
			InputStream inUrl = new URL("http://google.com").openStream(); // Создаем обьект URL с путем к странице и используем метод openStream - создаем входной поток для чтения файла ресурса, связанного с созданным обьектом класса URL
			readAllByByte(inUrl);
			System.out.print("\n\n\n");
			inUrl.close();
			
			// С потоком связан массив типа byte
			InputStream inArray = new ByteArrayInputStream(new byte [] {7,9,3,7,4}); // класс ByteArrayInputStream - класс потока ввода, который читает из массива типа byte
			readAllByByte(inArray);
			System.out.print("\n\n\n");
			inArray.close();
		}
		catch(IOException e) { // обработка исключении класса IOException
			System.out.println("ОШИБКА!!!" + e);
		}
	}

}
