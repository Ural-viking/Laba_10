package L_10_Examples;

//			Чтение из одного файла и запись в другой файл данных посимвольно

import java.io.*;

public class L10_6 {
	public static void main(String[] args) throws IOException{
		Reader in = null;
		Writer out = null;
		try {
			in = new FileReader("C:\\Papka1\\MyFile.txt"); // этот файл читаем
			out = new FileWriter("C:\\Papka1\\MyFile2.txt",true); // этот файл для записи
			// Данные считываются и записываются побайтно, как и для InputStream/OutputStream
			int oneByte; // переменная, в которую считываются данные
			while ((oneByte = in.read()) != -1) {
				// out.write((char)oneByte); // запись с уничтожением ранее
				// существующих данных
				out.append((char)oneByte); // запись с добавлением данных в конец
				System.out.print((char)oneByte);
				}
		}
		catch (IOException e) {
			System.out.println("Ошибка!!!!");
		}
		finally{
			in.close();
			out.close();
		}
	}
}