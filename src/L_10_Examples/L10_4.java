package L_10_Examples;

/*			Создать первый файл на диске и записать в него заданное количество вещественных чисел.
 * 			Далее создать второй файл и переписать в него все числа из первого файла.  */

import java.io.*;
import java.util.*;

public class L10_4 {
	public static void main(String[] args) {
		try {
			// Создание папки My и файла numIsh.txt, расположенного в ней, и сканера для записи в него чисел типа float
			File f1 = new File("C:\\My\\numIsh.txt");
			f1.createNewFile();
			Scanner sc =new Scanner(System.in,"cp1251");
			// создание обьекта класса DataOutputStream. Создание нового потока вывода данных для записи данных в указанный далее файл.
			DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsoluteFile()));
			// Обращение к пользователю
			System.out.println("Сколько вещественных чисел записать в файл?");
			// Сколько чисел хочет записать пользователь
			int count = sc.nextInt();
			// Пользователь вводит числа, которые имеют тип числа с плавающей точкой
			System.out.println("Введите числа: ");
			for(int i=0;i<count;i++) {
				wr.writeFloat(sc.nextFloat());
			}
			wr.flush(); // метод flush - используется для принудительной записи данных в целевой поток
			wr.close();
			
			// Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
			File f2 = new File("C:\\My\\numRez.txt");
			f2.createNewFile();
			// поток для чтения из исходного файла numIsh.txt
			DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
			// поток для записи в результирующий файл numRez.txt
			wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));
			
			try {
				while(true) {
					float number = rd.readFloat();
					wr.writeFloat(number);
					System.out.println("Число " + (float)number);
				}
			}
			catch(EOFException e) {
				wr.flush();
				wr.close();
				rd.close();
			}
		}
			catch(IOException e) {
				System.out.println("End of file");
			}
	}
}