package L_10_Examples;

import java.io.*;

// Пример 1. Создание файлов и папок

public class L10_1 {
	public static void main(String[] args) {
		// Работу с файлами всегда стоит проводить в блоках try-catch
		try {
			//Создание файла в текущей папке( где расположен файл L10_1.java)
			File f1 = new File("MyFile1.txt"); // создаем обьект класса File , но формально его не существует 
			f1.createNewFile(); // метод createNewFile() - создает файл
			if(f1.exists()) { // метод  exists() - возвращает true, если файл с таким именем существует на диске компьютера 
				System.out.println("Создан!!!");
				System.out.println("Полный путь файла:  " + f1.getAbsolutePath()); // метод getAbsolutePath() - возвращает полный путь файла со всеми поддиректориями
			}
			
			//Создание файла на диске C и вывод полного пути
			File f2 = new File("C:\\Papka1\\MyFile2.txt");
			f2.createNewFile();
			System.out.println("Полный путь файла:  " + f2.getAbsolutePath());
			
			//Создание нескольких вложенных папок
			File f3 = new File("C:\\Papka1\\Papka2\\Papka3");
			f3.mkdirs(); // метод mkdirs - создает директорию и все поддиректории
			System.out.println("Полный путь файла:  " + f3.getAbsolutePath());
		}
		catch(Exception e) { 
			System.out.println("ОШИБКА!!! " + e);
		}
	}
}