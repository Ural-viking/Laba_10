package L_10_Examples;

//			Создать файл на диске, ввести заданное с клавиатуры количество строк текста и записать их в файл в формате UTF-8

import java.io.*;
import java.util.*;

public class L10_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.print("Введите имя файла =>");
		String fileName = sc.nextLine();
		try {
			// Создается файл
			File f1 = new File(fileName);
			f1.createNewFile();
			System.out.println("Полный путь файла: " + f1.getAbsolutePath());
			System.out.print("Введите количество строк для записи в файл =>");
			int n = sc2.nextInt();
			// Создается поток для записи с учетом типа данных – DataOutputStream,
			// и ему в качестве параметра передается поток FileOutputStream
			DataOutputStream dOut = new DataOutputStream( new FileOutputStream(f1));
//			sc.nextLine(); 		//очистка буфера
			for (int i = 0; i < n; i++) {
				System.out.print("Введите строку для записи в файл => ");
				String s = sc.nextLine();
				dOut.writeUTF(s + "\n");	 //запись отдельных строк
			}
			dOut.flush();	 // дописываем несохраненные данные на диск
			dOut.close();	 // закрываем поток
			// Чтение и вывод данных из созданного файла
			DataInputStream dIn = new DataInputStream(new FileInputStream(f1));
			while(true) {
				System.out.println(dIn.readUTF());
			}
		}
		catch(EOFException e) {
		}
		catch(Exception e) {
			System.out.println("" + e);
		}
	}
}