package L_10_Examples;

// Чтение из одного файла и запись в другой файл данных построчно с использованием буфера в 1 килобайт

import java.io.*;

public class L10_7 {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter out = null;
		try {
			// Создание файловых символьных потоков для чтения и записи
			br = new BufferedReader( new FileReader("C:\\My\\numIsh.txt"),1024);
			out = new BufferedWriter(new FileWriter("C:\\My\\numRez.txt"));
			
			int lineCount = 0;
			String s;
			// Переписывание информации из одного файла в другой
			while((s = br.readLine())!= null) {
				lineCount++;
				System.out.println(lineCount + ":" + s);
				out.write(s);
				out.newLine();   // переход на новую строку
			}
		}
		catch(IOException e) {
			System.out.println("ОШИБКА!!!");
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}